package com.employmentAnyone.data.model.entity.employee;

import com.employmentAnyone.data.enums.EmploymentStatus;
import com.employmentAnyone.data.model.entity.AllAuditingEntity;
import com.employmentAnyone.data.model.entity.user.Company;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "employ_center")
@Getter
@Builder
@AllArgsConstructor
public class EmploymentCenter extends AllAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL COMMENT '제목'")
    private String title;

    @Column(columnDefinition = "VARCHAR(10) NOT NULL COMMENT '도시명'")
    private String city;

    @Column(columnDefinition = "VARCHAR(10) NOT NULL COMMENT '동'")
    private String dong;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL COMMENT '주소'")
    private String address;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL COMMENT '연락처'")
    private String phone;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL COMMENT '연락처 sub'")
    private String phoneSub;

    @Column(columnDefinition = "MEDIUMTEXT NOT NULL COMMENT '상세설명'")
    private String contents;

    @Column(columnDefinition = "BIGINT NOT NULL COMMENT '첫 번째 카테고리 ID'")
    private Long category1Id;

    @Column(columnDefinition = "BIGINT NOT NULL COMMENT '첫 번째 카테고리 이름'")
    private Long category1Name;

    @Column(columnDefinition = "BIGINT NULL COMMENT '두 번째 카테고리 ID'")
    private Long category2Id;

    @Column(columnDefinition = "BIGINT NULL COMMENT '두 번째 카테고리 이름'")
    private Long category2Name;

    @Column(columnDefinition = "BIGINT NULL COMMENT '세 번째 카테고리 ID'")
    private Long category3Id;

    @Column(columnDefinition = "BIGINT NULL COMMENT '세 번째 카테고리 이름'")
    private Long category3Name;

    @Column(columnDefinition = "DECIMAL(16, 8) NOT NULL COMMENT '지도 좌표 lat'")
    private BigDecimal lat;

    @Column(columnDefinition = "DECIMAL(16, 8) NOT NULL COMMENT '지도 좌표 lng'")
    private BigDecimal lng;

    @Column(columnDefinition = "DATE NOT NULL COMMENT '시작일'")
    private LocalDate startDate;

    @Column(columnDefinition = "DATE NOT NULL COMMENT '마감일'")
    private LocalDate endDate;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL DEFAULT 'WAIT' COMMENT '상태 WAIT, WAIT_PERSON, COMPLETE, EXPIRE_DATE'")
    private EmploymentStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;
}
