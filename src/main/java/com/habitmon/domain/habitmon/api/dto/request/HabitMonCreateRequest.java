package com.habitmon.domain.habitmon.api.dto.request;

public record HabitMonCreateRequest(
        Long memberId,
        String name
) {
}
