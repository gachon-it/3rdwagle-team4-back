package com.habitmon.domain.habitmon.domain;

import com.habitmon.domain.member.domain.Member;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    private Member member;

    @NotNull
    private String name;

    @NotNull
    private String age;

    @Builder
    public HabitMon(
            final String name,
            final String age,
            final Member member
    ) {
        this.name = name;
        this.age = age;
        this.member = member;
    }
}
