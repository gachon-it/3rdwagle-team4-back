package com.habitmon.domain.habit.domain.api.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record HabitCreateRequest(
        String name,
        LocalDate start_date,
        LocalDate end_date,
        boolean complete,
        String period,
        Integer count
) {
}
