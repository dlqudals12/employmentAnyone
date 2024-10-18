package com.employmentAnyone.global.exception;

import com.employmentAnyone.data.enums.ResponseCode;

public class DataNotFountException extends BusinessException {

    public DataNotFountException() {
        super(ResponseCode.DATA_NOT_FOUND);
    }

    public DataNotFountException(String msg) {
        super(ResponseCode.DATA_NOT_FOUND.getCode(), msg);
    }
}
