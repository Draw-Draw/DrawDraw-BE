package com.samtilee.drawdraw.auth.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    /* 401 UNAUTHORIZED : 권한 없음 */
    INVALID_TOKEN(UNAUTHORIZED, "유효하지 않은 토큰입니다."),
    INVALID_KEY(UNAUTHORIZED, "유효하지 않은 키입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
