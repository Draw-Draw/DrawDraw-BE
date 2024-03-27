package com.samtilee.drawdraw.diaryCover.exception;

import com.samtilee.drawdraw.diaryCover.message.ErrorMessage;
import lombok.Getter;

@Getter
public class DiaryCoverException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public DiaryCoverException(ErrorMessage errorMessage) {
        super("[DiaryCoverException] : " + errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
