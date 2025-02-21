package com.habitmon.domain.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String nickname;

    @NotNull
    private String ageRange;

    @NotNull
    private String gender;

    @NotNull
    private String job;

    @Builder
    public Member(
            final String email,
            final String password,
            final String nickname,
            final String ageRange,
            final String gender,
            final String job
    ) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.ageRange = ageRange;
        this.gender = gender;
        this.job = job;
    }
}
