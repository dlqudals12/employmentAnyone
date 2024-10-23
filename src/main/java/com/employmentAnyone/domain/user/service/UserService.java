package com.employmentAnyone.domain.user.service;

import com.employmentAnyone.config.security.jwt.JwtProvider;
import com.employmentAnyone.data.dto.user.CustomUserDetail;
import com.employmentAnyone.data.enums.JwtTokenType;
import com.employmentAnyone.data.enums.UserPermissionType;
import com.employmentAnyone.data.enums.UserType;
import com.employmentAnyone.data.model.entity.user.Company;
import com.employmentAnyone.data.model.entity.user.User;
import com.employmentAnyone.data.repository.company.CompanyRepository;
import com.employmentAnyone.data.repository.user.UserRepository;
import com.employmentAnyone.domain.user.dto.request.UserLoginRequest;
import com.employmentAnyone.domain.user.dto.request.UserSaveRequest;
import com.employmentAnyone.domain.user.dto.request.UserUpdateRequest;
import com.employmentAnyone.global.exception.DataNotFountException;
import com.employmentAnyone.global.exception.InvalidRequestException;
import com.employmentAnyone.global.util.CookieUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder encoder;

    @Transactional
    public void register(UserSaveRequest userSaveRequest) {
        boolean isPermissionCompany = userSaveRequest.getPermission() == UserPermissionType.COMPANY;

        Company company = null;
        if (isPermissionCompany) {
            companyRepository.findByName(userSaveRequest.getCompanyName()).ifPresent(
                    value -> {
                        throw new DataNotFountException();
                    }
            );

            company = companyRepository.save(Company.builder()
                    .name(userSaveRequest.getCompanyName())
                    .ceo(userSaveRequest.getCeo())
                    .city(userSaveRequest.getCity())
                    .dong(userSaveRequest.getDong())
                    .address(userSaveRequest.getAddress())
                    .phone(userSaveRequest.getCompanyPhone())
                    .phoneSub(userSaveRequest.getCompanyPhoneSub())
                    .build());
        }

        register(userSaveRequest, isPermissionCompany, company);
    }

    @Transactional
    public void registerSub(UserSaveRequest userSaveRequest) {
        if (userSaveRequest.getPermission() != UserPermissionType.COMPANY
                || userSaveRequest.getUserType() != UserType.SUB) {
            throw new InvalidRequestException();
        }

        Company company = companyRepository.findById(userSaveRequest.getCompanyId()).orElseThrow(DataNotFountException::new);

        register(userSaveRequest, true, company);
    }

    @Transactional
    public void update(UserUpdateRequest userSaveRequest) {
        User user = userRepository.findByUserId(userSaveRequest.getId()).orElseThrow(DataNotFountException::new);

        User updateUser = User.builder()
                .password(encoder.encode(userSaveRequest.getPassword()))
                .userName(userSaveRequest.getName())
                .email(userSaveRequest.getEmail())
                .build();

        user.update(updateUser);
    }

    public CustomUserDetail login(UserLoginRequest userLoginRequest, HttpServletResponse response) throws AuthenticationException {
        try {
            User user = userRepository.findByUserId(userLoginRequest.getId()).orElseThrow(DataNotFountException::new);

            if (!encoder.matches(userLoginRequest.getPassword(), user.getPassword())) {
                throw new AuthenticationException();
            }

            CustomUserDetail customUserDetail = new CustomUserDetail(user);

            createTokenCookie(customUserDetail, response);

            return customUserDetail;
        } catch (Exception e) {
            if (e instanceof AuthenticationException) {
                log.debug("PASSWORD ERROR -> id: {}", userLoginRequest.getId());
            }

            throw new AuthenticationException();
        }
    }

    public void refresh(HttpServletRequest request, HttpServletResponse response) {
        CustomUserDetail user = jwtProvider.validRefresh(request, response);

        createTokenCookie(user, response);
    }

    private void createTokenCookie(CustomUserDetail customUserDetail, HttpServletResponse response) {
        JwtProvider.JwtTokenDto access = jwtProvider.generate(customUserDetail, JwtTokenType.ACCESS);
        JwtProvider.JwtTokenDto refresh = jwtProvider.generate(customUserDetail, JwtTokenType.REFRESH);

        CookieUtils.createTokenCookies(access, response);
        CookieUtils.createTokenCookies(refresh, response);
    }

    private void register(UserSaveRequest userSaveRequest, boolean isPermissionCompany, Company company) {
        userRepository.findByUserId(userSaveRequest.getId()).ifPresent(
                user -> {
                    throw new DataNotFountException();
                }
        );

        userRepository.save(User.builder()
                .userId(userSaveRequest.getId())
                .password(encoder.encode(userSaveRequest.getPassword()))
                .userName(userSaveRequest.getName())
                .email(userSaveRequest.getEmail())
                .role(userSaveRequest.getRole())
                .company(isPermissionCompany ? company : null)
                .build());
    }
}
