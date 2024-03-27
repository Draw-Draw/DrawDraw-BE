package com.samtilee.drawdraw.member.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {

    SUCCESS_CREATE_PROFILE("프로필 생성 성공"),
    ;

    private final String message;
}
