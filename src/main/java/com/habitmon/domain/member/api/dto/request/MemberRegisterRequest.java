package com.habitmon.domain.member.api.dto.request;

public record MemberRegisterRequest(
        String email,
        String password,
        String ageRange,
        String nickname,
        String gender,
        String job
) {
}
