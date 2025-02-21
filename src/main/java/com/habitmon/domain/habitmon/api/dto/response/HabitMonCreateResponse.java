package com.habitmon.domain.habitmon.api.dto.response;

public record HabitMonCreateResponse(
        Long habitMonId,
        String accessToken,
        String refreshToken
) {
}
