package com.habitmon.domain.habit.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cycle {
    @Id
    private Long id;

    @NotNull
    @OneToOne
    private Habit habit;

    @NotNull
    private String period;

    @NotNull
    private Integer count;

    @Builder
    public Cycle(
            final Habit habit,
            final String period,
            final Integer count
    ) {
        this.period = period;
        this.count = count;
        this.habit = habit;
    }
}
