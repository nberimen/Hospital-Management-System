package com.nberimen.hospitalmanagementsystem.gen.exceptions;

import com.nberimen.hospitalmanagementsystem.gen.enums.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthException extends GenBusinessException {
    public AuthException(BaseErrorMessage message) {
        super(message);
    }
}
