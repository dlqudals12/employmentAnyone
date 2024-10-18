package com.employmentAnyone.domain.user.dto.request;

import com.employmentAnyone.data.enums.UserPermissionType;
import com.employmentAnyone.data.enums.UserRoleType;
import com.employmentAnyone.data.enums.UserType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserSaveRequest {

    @NotNull
    private String id;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private UserRoleType role;

    private UserPermissionType permission;

    private UserType userType;

    private String companyName;

    private String ceo;

    private String city;

    private String dong;

    private String address;

    private String companyPhone;

    private String companyPhoneSub;

    private Long companyId;
}
