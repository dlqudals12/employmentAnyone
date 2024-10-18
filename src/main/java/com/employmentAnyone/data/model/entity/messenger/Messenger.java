package com.employmentAnyone.data.model.entity.messenger;

import com.employmentAnyone.data.enums.MessengerType;
import com.employmentAnyone.data.model.entity.AllAuditingEntity;
import com.employmentAnyone.data.model.entity.employee.EmploymentCenter;
import com.employmentAnyone.data.model.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "messenger")
@Getter
@Builder
@AllArgsConstructor
public class Messenger extends AllAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) NOT NULL COMMENT '채팅 타입'")
    private MessengerType type;

    @Column(columnDefinition = "TINYINT NOT NULL DEFAULT '1' COMMENT '채팅 오픈 여부'")
    private Boolean isOpen;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "employer")
    private User employer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "employee")
    private User employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "employment_center_id")
    private EmploymentCenter employmentCenter;
}
