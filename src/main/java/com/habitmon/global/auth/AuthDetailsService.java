package com.habitmon.global.auth;

import com.habitmon.domain.member.domain.Member;
import com.habitmon.domain.member.domain.repository.MemberRepository;
import com.habitmon.domain.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public AuthDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
        return new AuthDetails(member.getId(), member.getNickname(), "ROLE_USER");
    }
}
