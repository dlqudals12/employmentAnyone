package com.employmentAnyone.data.model.entity.user;

import com.employmentAnyone.data.model.entity.AllAuditingEntity;
import com.employmentAnyone.data.model.entity.employee.EmploymentCenter;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "company",
        uniqueConstraints = {
                @UniqueConstraint(name = "UNIQUE_COMPANY", columnNames = "name")
        })
@Getter
@Builder
@AllArgsConstructor
public class Company extends AllAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL COMMENT '상호명'")
    private String name;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL COMMENT 'ceo'")
    private String ceo;

    @Column(columnDefinition = "VARCHAR(10) NOT NULL COMMENT '도시명'")
    private String city;

    @Column(columnDefinition = "VARCHAR(10) NOT NULL COMMENT '동'")
    private String dong;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL COMMENT '주소'")
    private String address;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL COMMENT '연락처'")
    private String phone;

    @Column(columnDefinition = "VARCHAR(20) NULL COMMENT '연락처 sub'")
    private String phoneSub;

    @OneToMany(mappedBy = "company")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<EmploymentCenter> employmentCenters = new ArrayList<>();
}
