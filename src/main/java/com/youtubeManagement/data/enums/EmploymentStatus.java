package com.youtubeManagement.data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EmploymentStatus {
    WAIT("대기"), 
    WAIT_PERSON("고용중"),
    COMPLETE("고용 완료"),
    EXPIRE_DATE("기간 만료");
    private final String value;
}
