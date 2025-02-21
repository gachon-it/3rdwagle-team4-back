package com.habitmon.global.jwt.exception;

import com.habitmon.common.ErrorCode;
import com.habitmon.common.exception.ServiceException;

public class MalformedTokenException extends ServiceException {
    public MalformedTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
