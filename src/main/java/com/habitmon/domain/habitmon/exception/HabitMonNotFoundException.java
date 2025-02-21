package com.habitmon.domain.habitmon.exception;

import com.habitmon.common.ErrorCode;
import com.habitmon.common.exception.ServiceException;

public class HabitMonNotFoundException extends ServiceException {
    public HabitMonNotFoundException(ErrorCode errorCode) {
        super(ErrorCode.HABITMON_NOT_FOUND);
    }
}
