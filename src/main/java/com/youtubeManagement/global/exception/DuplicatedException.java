package com.youtubeManagement.global.exception;

import com.youtubeManagement.data.enums.ResponseCode;

public class DuplicatedException extends BusinessException {
    public DuplicatedException() {
        super(ResponseCode.DUPLICATED);
    }
}
