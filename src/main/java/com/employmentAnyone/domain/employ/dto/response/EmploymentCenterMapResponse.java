package com.employmentAnyone.domain.employ.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EmploymentCenterMapResponse {
    private String title;
    private String city;
    private String dong;
    private String address;
    private String phone;
    private Long category1Id;
    private String category1Name;
    private Long category2Id;
    private String category2Name;
    private Long category3Id;
    private String category3Name;
    private BigDecimal lat;
    private BigDecimal lng;
}
