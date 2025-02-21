package com.habitmon.domain.member.api.dto.response;

import com.habitmon.domain.member.domain.Member;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public record MemberInfoResponse(
        Long id,
        String email,
        String password,
        String nickname,
        String ageRange,
        String gender,
        String job

) {
}