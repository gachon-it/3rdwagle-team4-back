package com.habitmon.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessCode {
    REQUEST_OK(200, "OK", "요청이 성공적으로 처리되었습니다."),
    LOGIN_SUCCESS(200, "LOGIN_SUCCESS", "소셜 로그인이 정상적으로 처리되었습니다.");

    private final int httpStatus;
    private final String code;
    private final String message;
}
