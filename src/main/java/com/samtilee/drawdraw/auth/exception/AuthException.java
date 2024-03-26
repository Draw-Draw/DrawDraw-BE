package com.samtilee.drawdraw.auth.exception;

import com.samtilee.drawdraw.auth.message.ErrorMessage;
import lombok.Getter;

@Getter
public class AuthException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public AuthException(ErrorMessage errorMessage) {
        super("[AuthException] : " + errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
