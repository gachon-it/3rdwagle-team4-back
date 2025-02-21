package com.habitmon.domain.habit.domain.api.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record HabitCreateRequest(
        String name,
        LocalDate startDate,
        LocalDate endDate,
        String period,
        Integer count
) {
}
