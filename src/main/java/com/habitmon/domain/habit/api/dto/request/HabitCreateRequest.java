package com.habitmon.domain.habit.api.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record HabitCreateRequest(
        String name,
        LocalDate startDate,
        LocalDate endDate
) {
}
