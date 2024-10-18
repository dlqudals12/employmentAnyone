package com.employmentAnyone.global.exception;

import com.employmentAnyone.data.enums.ResponseCode;

public class InvalidRequestException extends BusinessException {
    public InvalidRequestException() {
        super(ResponseCode.INVALID_REQUEST);
    }
}
