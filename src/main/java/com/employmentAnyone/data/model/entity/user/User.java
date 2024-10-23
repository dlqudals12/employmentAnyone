package com.employmentAnyone.data.model.entity.user;

import com.employmentAnyone.data.enums.UserPermissionType;
import com.employmentAnyone.data.enums.UserRoleType;
import com.employmentAnyone.data.enums.UserType;
import com.employmentAnyone.data.model.entity.AllAuditingEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.StringUtils;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table
@Getter
@Builder
@AllArgsConstructor
public class User extends AllAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(20) NOT NULL COMMENT '사용자 ID'")
    private String userId;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) NOT NULL COMMENT '패스워드'")
    private String password;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) NOT NULL COMMENT '이메일'")
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(20) NOT NULL COMMENT '유저명'")
    private String userName;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) NOT NULL COMMENT '유저 권한 유형'")
    private UserPermissionType permission;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) NOT NULL COMMENT '유저 유형'")
    private UserType userType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(10) NOT NULL COMMENT '유저 권한 USER, ADMIN'")
    private UserRoleType role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    public void update(User updateUser) {
        if(StringUtils.hasLength(updateUser.getUserName())) this.userName = updateUser.getUserName();
        if(StringUtils.hasLength(updateUser.getPassword())) this.password = updateUser.getPassword();
        if(StringUtils.hasLength(updateUser.getEmail())) this.email = updateUser.getEmail();
    }
}
