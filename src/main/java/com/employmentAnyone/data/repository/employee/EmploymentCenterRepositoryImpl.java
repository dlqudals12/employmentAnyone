package com.employmentAnyone.data.repository.employee;

import com.employmentAnyone.data.model.entity.employee.QEmploymentCenter;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmploymentCenterRepositoryImpl implements EmploymentCenterRepositoryCustom {

    private final QEmploymentCenter employmentCenter = QEmploymentCenter.employmentCenter;
    private final JPAQueryFactory jpaQueryFactory;


}
