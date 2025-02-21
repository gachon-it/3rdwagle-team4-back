package com.habitmon.domain.habit.exception;

import com.habitmon.common.ErrorCode;
import com.habitmon.common.exception.ServiceException;

public class HabitNotFoundException extends ServiceException {
    public HabitNotFoundException(ErrorCode errorCode) {
        super(ErrorCode.HABIT_NOT_FOUND);
    }
}
