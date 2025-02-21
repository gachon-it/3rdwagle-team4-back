package com.habitmon.domain.habit.domain.api.dto.response;

import java.util.List;

public record HabitListResponse(
        List<HabitResponse> habitList
) {
    public record HabitResponse(
            Long habitId,
            String name
    ) {}
}
