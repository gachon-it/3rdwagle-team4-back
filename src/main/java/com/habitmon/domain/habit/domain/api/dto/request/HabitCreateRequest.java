package com.habitmon.domain.habit.domain.api.dto.request;

import java.time.LocalDate;

public record HabitCreateRequest(
        String name,
        LocalDate start_date,
        LocalDate end_date,
        boolean complete
) {
}
