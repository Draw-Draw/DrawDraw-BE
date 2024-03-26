package com.samtilee.drawdraw.common.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Getter
@Configuration
public class ValueConfig {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.KAKAO_URL}")
    private String kakaoUri;

    @Value("${jwt.ACCESS_TOKEN_EXPIRED}")
    private Long accessTokenExpired;

    @Value("${jwt.REFRESH_TOKEN_EXPIRED}")
    private Long refreshTokenExpired;

    private final String BEARER_HEADER = "Bearer ";
    private final String BLANK = "";

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
    }
}
