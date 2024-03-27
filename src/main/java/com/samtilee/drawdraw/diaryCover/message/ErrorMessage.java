package com.samtilee.drawdraw.diaryCover.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    /* 400 BAD_REQUEST : 잘못된 요청 */
    INVALID_TYPE(BAD_REQUEST, "유효하지 않은 일기장 타입입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
