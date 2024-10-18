package com.employmentAnyone.global.util;

import com.employmentAnyone.config.security.jwt.JwtProvider;
import com.employmentAnyone.data.enums.JwtTokenType;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtils {

    private static final String cookiePath = "/";

    public static void createTokenCookies(JwtProvider.JwtTokenDto tokenDto, HttpServletResponse response) {
        Cookie cookie = new Cookie(tokenDto.tokenType().getValue(), tokenDto.token());
        cookie.setPath(cookiePath);
        cookie.setHttpOnly(true);
        cookie.setMaxAge((int) tokenDto.expire() / 1000);

        response.addCookie(cookie);
    }

    public static void deleteTokenCookies(HttpServletResponse response) {
        deleteCookie(JwtTokenType.REFRESH.getValue(), response);
        deleteCookie(JwtTokenType.ACCESS.getValue(), response);
    }

    public static void deleteCookie(String name, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, "");
        cookie.setPath(cookiePath);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);

        response.addCookie(cookie);
    }
}
