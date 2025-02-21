package com.habitmon.global.handler;

import com.habitmon.common.ErrorCode;
import com.habitmon.common.exception.ServiceException;
import com.habitmon.common.response.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ApiResponse<Void> handleServiceException(ServiceException e) {
        return ApiResponse.error(e.getErrorCode());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<Void> handleGeneralException(Exception e) {
        e.printStackTrace();
        return ApiResponse.error(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
