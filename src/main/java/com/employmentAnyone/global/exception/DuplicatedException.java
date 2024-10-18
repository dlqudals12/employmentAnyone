package com.employmentAnyone.global.exception;

import com.employmentAnyone.data.enums.ResponseCode;

public class DuplicatedException extends BusinessException {
    public DuplicatedException() {
        super(ResponseCode.DUPLICATED);
    }
}
