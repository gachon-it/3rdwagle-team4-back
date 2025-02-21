package com.habitmon.domain.habit.domain.api.dto.request;

import com.habitmon.domain.habit.domain.Habit;

public record CycleCreateRequest(
        Habit habit,
        String period,
        Integer count
) {
}
