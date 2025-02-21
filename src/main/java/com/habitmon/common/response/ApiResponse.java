package com.habitmon.common.response;

import com.habitmon.common.ErrorCode;
import com.habitmon.common.SuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private final int status;
    private final String code;
    private final String message;
    private T data;

    public static ApiResponse<Void> success(SuccessCode successCode) {
        return new ApiResponse<>(successCode.getHttpStatus(), successCode.getCode(), successCode.getMessage());
    }

    public static <T> ApiResponse<T> success(SuccessCode successCode, T data) {
        return new ApiResponse<T>(successCode.getHttpStatus(), successCode.getCode(), successCode.getMessage(), data);
    }

    public static ApiResponse<Void> error(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode.getHttpStatus(), errorCode.getCode(), errorCode.getMessage());
    }
}
