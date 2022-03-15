package com.nberimen.hospitalmanagementsystem.gen.exceptions;

import com.nberimen.hospitalmanagementsystem.gen.enums.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends GenBusinessException {
    public ItemNotFoundException(BaseErrorMessage message) {
        super(message);
    }
}
