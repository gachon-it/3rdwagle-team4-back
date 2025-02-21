package com.habitmon.global.jwt;

import com.habitmon.common.dto.response.JwtResponse;
import com.habitmon.global.auth.AuthDetails;
import com.habitmon.global.auth.AuthDetailsService;
import com.habitmon.global.jwt.exception.ExpiredTokenException;
import com.habitmon.global.jwt.exception.InvalidTokenException;
import com.habitmon.global.jwt.exception.MalformedTokenException;
import com.habitmon.global.jwt.exception.UnsupportedTokenException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Service
public class JwtProvider {

    public static final Duration REFRESH_TOKEN_DURATION = Duration.ofDays(14);
    public static final Duration ACCESS_TOKEN_DURATION = Duration.ofDays(6);
    public static final String ROLE = "ROLE_USER";

    private final SecretKey secretKey;
    private final AuthDetailsService authDetailsService;

    @Autowired
    public JwtProvider(@Value("${jwt.secret_key}") String secretKey,
                       AuthDetailsService authDetailsService) {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
        this.authDetailsService = authDetailsService;
    }

    @Transactional
    public JwtResponse refreshAccessToken(String refreshToken) {
        Claims claims = validateToken(refreshToken);
        Long memberId = claims.get("id", Long.class);

        String newAccessToken = generateAccessToken(memberId, claims.getSubject());
        return new JwtResponse(newAccessToken, null);
    }

    public String generateAccessToken(Long memberId, String email) {
        return generateToken(memberId, email, ACCESS_TOKEN_DURATION);
    }

    public String generateRefreshToken(Long memberId, String tokenSubject) {
        return generateToken(memberId, tokenSubject, REFRESH_TOKEN_DURATION);
    }

    private String generateToken(Long memberId, String email, Duration duration) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + duration.toMillis());

        return Jwts.builder()
                .subject(email)
                .claim("id", memberId)
                .claim("role", ROLE)
                .expiration(expiry)
                .signWith(secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = validateToken(token);
        Collection<? extends GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority(claims.get("role").toString()));

        return new UsernamePasswordAuthenticationToken(getDetails(claims), "", authorities);
    }

    private AuthDetails getDetails(Claims claims) {
        return this.authDetailsService.loadUserByUsername(claims.getSubject());
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .verifyWith(secretKey).build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Claims validateToken(String token) {
        try {
            return parseClaims(token);
        } catch (IllegalArgumentException e) {
            throw new InvalidTokenException();
        } catch (ExpiredJwtException e) {
            throw new ExpiredTokenException();
        } catch (MalformedJwtException e) {
            throw new MalformedTokenException();
        } catch (UnsupportedJwtException e) {
            throw new UnsupportedTokenException();
        }
    }

    public boolean isInvalidToken(String token) {
        try {
            validateToken(token);
            return false;
        } catch (InvalidTokenException |
                 ExpiredTokenException |
                 MalformedTokenException |
                 UnsupportedTokenException e) {
            return true;
        }
    }
}
