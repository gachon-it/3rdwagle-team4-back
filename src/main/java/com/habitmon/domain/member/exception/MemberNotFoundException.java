package com.habitmon.domain.member.exception;

import com.habitmon.common.ErrorCode;
import com.habitmon.common.exception.ServiceException;

public class MemberNotFoundException extends ServiceException {
    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }
}
