package com.habitmon.domain.habit.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private Boolean complete;

    @Builder
    public Habit(
            final String name,
            final LocalDate startDate,
            final LocalDate endDate,
            final Boolean complete
    ) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.complete = complete;
    }
}
