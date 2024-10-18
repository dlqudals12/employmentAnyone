package com.youtubeManagement.global.exception;

import com.youtubeManagement.data.enums.ResponseCode;

public class InvalidRequestException extends BusinessException {
    public InvalidRequestException() {
        super(ResponseCode.INVALID_REQUEST);
    }
}
