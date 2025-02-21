package com.habitmon.domain.member.api.dto.request;

public record MemberRegisterRequest(
        String ageRange,
        String nickname,
        String gender
) {
}
