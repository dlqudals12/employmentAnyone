package com.youtubeManagement.data.model.entity.employee;

import com.youtubeManagement.data.model.entity.RegDtAuditingEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "employ_category")
@Getter
@Builder
@AllArgsConstructor
public class EmploymentCategory extends RegDtAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL COMMENT '카테고리명'")
    private String name;

    @Column(columnDefinition = "BIGINT NULL COMMENT '상위 카테고리 id'")
    private Long categoryId;

    @OneToMany(mappedBy = "employmentCategory")
    private List<EmploymentCenter> employmentCenters = new ArrayList<>();
}
