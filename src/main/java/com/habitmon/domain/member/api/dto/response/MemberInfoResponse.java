package com.habitmon.domain.member.api.dto.response;

public record MemberInfoResponse(
        Long id,
        String nickname,
        String ageRange,
        String gender
) {
}