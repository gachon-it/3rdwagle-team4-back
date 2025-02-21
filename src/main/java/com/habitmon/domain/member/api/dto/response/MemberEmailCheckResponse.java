package com.habitmon.domain.member.api.dto.response;

public record MemberEmailCheckResponse(
        String accessToken,
        String refreshToken
) {
}
