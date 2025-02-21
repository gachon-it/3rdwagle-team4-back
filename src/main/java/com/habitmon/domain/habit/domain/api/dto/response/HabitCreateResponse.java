package com.habitmon.domain.habit.domain.api.dto.response;

public record HabitCreateResponse(
        Long HabitId,
        String accessToken,
        String refreshToken
) {
}
