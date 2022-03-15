package com.nberimen.hospitalmanagementsystem.patient.enums;

import com.nberimen.hospitalmanagementsystem.gen.enums.BaseErrorMessage;

public enum PatientErrorMessage implements BaseErrorMessage {

    PATIENT_ERROR_MESSAGE("Patient not found!"),
    ;

    private String message;

    PatientErrorMessage(String message) {
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
