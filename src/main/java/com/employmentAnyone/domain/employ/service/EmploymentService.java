package com.employmentAnyone.domain.employ.service;

import com.employmentAnyone.data.model.entity.employee.EmploymentCenter;
import com.employmentAnyone.data.model.entity.user.Company;
import com.employmentAnyone.data.repository.company.CompanyRepository;
import com.employmentAnyone.data.repository.employee.EmploymentCategoryRepository;
import com.employmentAnyone.data.repository.employee.EmploymentCenterRepository;
import com.employmentAnyone.domain.employ.dto.request.EmploymentCenterSaveRequest;
import com.employmentAnyone.domain.employ.dto.response.EmploymentCenterMapResponse;
import com.employmentAnyone.global.exception.DataNotFountException;
import com.employmentAnyone.global.exception.DuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmploymentService {

    private final CompanyRepository companyRepository;
    private final EmploymentCategoryRepository employmentCategoryRepository;
    private final EmploymentCenterRepository employmentCenterRepository;

    @Transactional
    public void register(EmploymentCenterSaveRequest saveRequest) {
        employmentCenterRepository.findByTitle(saveRequest.getTitle()).ifPresent(
                value -> {
                    throw new DuplicatedException();
                }
        );

        Company company = companyRepository.findById(saveRequest.getCompanyId()).orElseThrow(DataNotFountException::new);

        employmentCenterRepository.save(EmploymentCenter.builder()
                .title(saveRequest.getTitle())
                .city(saveRequest.getCity())
                .dong(saveRequest.getDong())
                .address(saveRequest.getAddress())
                .phone(saveRequest.getPhone())
                .phoneSub(saveRequest.getPhoneSub())
                .contents(saveRequest.getContents())
                .category1Id(saveRequest.getCategory1Id())
                .category1Name(saveRequest.getCategory1Name())
                .category2Id(saveRequest.getCategory2Id())
                .category2Name(saveRequest.getCategory2Name())
                .category3Id(saveRequest.getCategory3Id())
                .category3Name(saveRequest.getCategory3Name())
                .lat(saveRequest.getLat())
                .lng(saveRequest.getLng())
                .startDate(saveRequest.getStartDate())
                .endDate(saveRequest.getEndDate())
                .status(saveRequest.getStatus())
                .company(company)
                .build());
    }

    public void employments(String city, String dong) {
        List<EmploymentCenterMapResponse> responses = employmentCenterRepository.searchAllMap(city, dong);
    }
}
