package com.employmentAnyone.domain.employ.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmploymentCenterResponse {
    private String title;
    private String city;
    private String dong;
    private Long category1Id;
    private String category1Name;
    private Long category2Id;
    private String category2Name;
    private Long category3Id;
    private String category3Name;
}
