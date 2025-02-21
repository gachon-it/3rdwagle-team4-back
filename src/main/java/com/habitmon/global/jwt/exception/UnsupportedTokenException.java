package com.habitmon.global.jwt.exception;

import com.habitmon.common.ErrorCode;
import com.habitmon.common.exception.ServiceException;

public class UnsupportedTokenException extends ServiceException {
    public UnsupportedTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
