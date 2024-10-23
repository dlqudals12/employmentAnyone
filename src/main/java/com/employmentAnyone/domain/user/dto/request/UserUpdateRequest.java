package com.employmentAnyone.domain.user.dto.request;

import com.employmentAnyone.data.enums.UserPermissionType;
import com.employmentAnyone.data.enums.UserRoleType;
import com.employmentAnyone.data.enums.UserType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserUpdateRequest {

    @NotNull
    private String id;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String name;
}
