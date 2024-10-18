package com.employmentAnyone.data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {
    OK(200, "Success"),
    DATA_NOT_FOUND(404, "Data not found"),
    INVALID_REQUEST(401, "INVALID_REQUEST"),
    DUPLICATED(409, "Duplicated");
    private final int code;
    private final String msg;
}
