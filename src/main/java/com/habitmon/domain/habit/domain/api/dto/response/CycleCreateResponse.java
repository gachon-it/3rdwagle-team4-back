package com.habitmon.domain.habit.domain.api.dto.response;

import com.habitmon.domain.habit.domain.Habit;

public record CycleCreateResponse(
        Long CycleId,
        String accessToken,
        String refreshToken
) {

}
