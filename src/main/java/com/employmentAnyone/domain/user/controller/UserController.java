package com.employmentAnyone.domain.user.controller;

import com.employmentAnyone.data.dto.response.SuccessResponse;
import com.employmentAnyone.domain.user.dto.request.UserSaveRequest;
import com.employmentAnyone.domain.user.dto.request.UserUpdateRequest;
import com.employmentAnyone.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User", description = "User")
@RestController
@RequiredArgsConstructor
@RequestMapping("/apis/v3/auth")
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원 수정", description = "회원 수정")
    @ApiResponse(responseCode = "200", description = "OK")
    @PatchMapping("")
    public SuccessResponse<Object> register(@RequestBody UserUpdateRequest userUpdateRequest) {
        userService.update(userUpdateRequest);
        return SuccessResponse.ok();
    }
}
