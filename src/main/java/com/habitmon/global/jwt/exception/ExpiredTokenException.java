package com.habitmon.global.jwt.exception;

import com.habitmon.common.ErrorCode;
import com.habitmon.common.exception.ServiceException;

public class ExpiredTokenException extends ServiceException {
    public ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
