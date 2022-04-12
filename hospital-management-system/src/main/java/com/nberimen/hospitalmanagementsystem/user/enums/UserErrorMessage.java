package com.nberimen.hospitalmanagementsystem.user.enums;

import com.nberimen.hospitalmanagementsystem.gen.enums.BaseErrorMessage;

public enum UserErrorMessage implements BaseErrorMessage {

    USER_ERROR_MESSAGE("User not found!"),
    UNAUTHORIZED_ERROR_MESSAGE("UNAUTHORIZED"),
    ;

    private String message;

    UserErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
