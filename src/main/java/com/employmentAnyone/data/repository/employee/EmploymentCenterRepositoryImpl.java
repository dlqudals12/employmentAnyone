package com.employmentAnyone.data.repository.employee;

import com.employmentAnyone.data.enums.EmploymentStatus;
import com.employmentAnyone.data.model.entity.employee.QEmploymentCenter;
import com.employmentAnyone.domain.employ.dto.response.EmploymentCenterMapResponse;
import com.employmentAnyone.domain.employ.dto.response.EmploymentCenterResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class EmploymentCenterRepositoryImpl implements EmploymentCenterRepositoryCustom {

    private final QEmploymentCenter employmentCenter = QEmploymentCenter.employmentCenter;
    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Page<EmploymentCenterResponse> searchAllPage(
            String title, String city, String dong, String address,
            Long category1Id, Long category2Id, Long category3Id, LocalDate startDate, LocalDate endDate) {
        jpaQueryFactory
                .select(Projections.bean(
                        EmploymentCenterResponse.class,
                        employmentCenter.title
                ))
                .from(employmentCenter)
                .where(cityEq(city),
                        dongEq(dong),
                        employmentCenter.status.in(EmploymentStatus.COMPLETE, EmploymentStatus.WAIT_PERSON))
                .fetch();

        return null;
    }

    @Override
    public List<EmploymentCenterMapResponse> searchAllMap(String city, String dong) {
        return jpaQueryFactory
                .select(Projections.bean(
                        EmploymentCenterMapResponse.class,
                        employmentCenter.title,
                        employmentCenter.city,
                        employmentCenter.dong,
                        employmentCenter.address,
                        employmentCenter.phone,
                        employmentCenter.category1Id,
                        employmentCenter.category1Name,
                        employmentCenter.category2Id,
                        employmentCenter.category2Name,
                        employmentCenter.category3Id,
                        employmentCenter.category3Name,
                        employmentCenter.lat,
                        employmentCenter.lng
                ))
                .from(employmentCenter)
                .where(cityEq(city),
                        dongEq(dong),
                        employmentCenter.status.in(EmploymentStatus.COMPLETE, EmploymentStatus.WAIT_PERSON))
                .fetch();
    }

    private BooleanExpression cityEq(String city) {
        return city != null ? employmentCenter.city.eq(city) : null;
    }

    private BooleanExpression dongEq(String dong) {
        return dong != null ? employmentCenter.dong.eq(dong) : null;
    }
}
