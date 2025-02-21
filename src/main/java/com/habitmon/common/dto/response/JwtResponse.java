package com.habitmon.common.dto.response;

public record JwtResponse(
        String accessToken,
        String refreshToken
) {
}
