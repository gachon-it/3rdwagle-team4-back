package com.habitmon.domain.habitmon.api.dto.response;

import com.habitmon.domain.habitmon.domain.HabitMon;

public record HabitMonInfoResponse(
        String name,
        String age
) {
}
