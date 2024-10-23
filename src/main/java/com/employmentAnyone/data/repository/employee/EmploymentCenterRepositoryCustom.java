package com.employmentAnyone.data.repository.employee;

import com.employmentAnyone.domain.employ.dto.response.EmploymentCenterMapResponse;
import com.employmentAnyone.domain.employ.dto.response.EmploymentCenterResponse;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface EmploymentCenterRepositoryCustom {

    Page<EmploymentCenterResponse> searchAllPage(String title, String city, String dong, String address,
                                                 Long category1Id, Long category2Id, Long category3Id, LocalDate startDate, LocalDate endDate);

    List<EmploymentCenterMapResponse> searchAllMap(String city, String dong);
}
