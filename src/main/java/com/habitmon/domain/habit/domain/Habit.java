package com.habitmon.domain.habit.domain;

import com.habitmon.domain.member.domain.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Member member;

    @NotNull
    private String name;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private Boolean complete;

    @NotNull
    private Integer count;

    @Builder(toBuilder = true)
    public Habit(
            final Member member,
            final String name,
            final LocalDate startDate,
            final LocalDate endDate,
            final Boolean complete,
            final Integer count
    ) {
        this.member = member;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.complete = complete;
        this.count = count;
    }
}
