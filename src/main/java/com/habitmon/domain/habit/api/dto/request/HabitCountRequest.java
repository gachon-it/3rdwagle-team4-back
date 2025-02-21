package com.habitmon.domain.habit.api.dto.request;

public record HabitCountRequest(
        Long habitId,
        Boolean isCheked
) {
}
