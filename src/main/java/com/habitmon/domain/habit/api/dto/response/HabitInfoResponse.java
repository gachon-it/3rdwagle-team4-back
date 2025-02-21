package com.habitmon.domain.habit.api.dto.response;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record HabitInfoResponse(
    String name,
    LocalDate startDate,
    LocalDate endDate,
    Boolean complete,
    Integer count
) {
}
