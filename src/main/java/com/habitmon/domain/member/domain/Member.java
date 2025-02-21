package com.habitmon.domain.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nickname;

    @NotNull
    private String ageRange;

    @NotNull
    private String gender;

    @Builder
    public Member(
            final String nickname,
            final String ageRange,
            final String gender
    ) {
        this.nickname = nickname;
        this.ageRange = ageRange;
        this.gender = gender;
    }
}
