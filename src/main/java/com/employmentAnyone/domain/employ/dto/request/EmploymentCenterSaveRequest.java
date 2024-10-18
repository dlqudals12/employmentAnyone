package com.employmentAnyone.domain.employ.dto.request;

import com.employmentAnyone.data.enums.EmploymentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class EmploymentCenterSaveRequest {

    @NotNull
    private String title;

    @NotNull
    private String city;

    @NotNull
    private String dong;

    @NotNull
    private String address;

    @NotNull
    private String phone;

    private String phoneSub;

    @NotNull
    private String contents;

    @NotNull
    private Long category1Id;

    @NotNull
    private Long category1Name;

    private Long category2Id;

    private Long category2Name;

    private Long category3Id;

    private Long category3Name;

    @NotNull
    private BigDecimal lat;

    @NotNull
    private BigDecimal lng;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private EmploymentStatus status;

    @NotNull
    private Long companyId;
}
