package com.habitmon.domain.habit.domain.api.dto.response;

public record HabitCycleCreateResponse(
        HabitCreateResponse habitCreateResponse,
        CycleCreateResponse cycleCreateResponse
) {
}
