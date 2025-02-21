package com.habitmon.domain.habitmon.domain;

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
public class HabitMon {
    @Id
    private Long id;

    @NotNull
    private Long memberId;

    @NotNull
    private String name;

    @NotNull
    private String age;

    @Builder
    public HabitMon(
            final String name,
            final String age,
            final Long memberId
    ) {
        this.name = name;
        this.age = age;
        this.memberId = memberId;
    }
}
