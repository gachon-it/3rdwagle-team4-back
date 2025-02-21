package com.habitmon.domain.member.api.dto.response;

public record MemberRegisterResponse(
        Long memberId,
        String accessToken,
        String refreshToken
) {
}
