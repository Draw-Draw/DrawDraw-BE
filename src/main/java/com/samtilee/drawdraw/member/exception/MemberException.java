package com.samtilee.drawdraw.member.exception;

import com.samtilee.drawdraw.member.message.ErrorMessage;
import lombok.Getter;

@Getter
public class MemberException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public MemberException(ErrorMessage errorMessage) {
        super("[MemberException] : " + errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
