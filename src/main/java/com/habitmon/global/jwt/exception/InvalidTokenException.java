package com.habitmon.global.jwt.exception;

import com.habitmon.common.ErrorCode;
import com.habitmon.common.exception.ServiceException;

public class InvalidTokenException extends ServiceException {
    public InvalidTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
