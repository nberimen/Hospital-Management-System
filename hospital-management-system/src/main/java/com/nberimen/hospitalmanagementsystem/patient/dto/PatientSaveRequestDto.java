package com.nberimen.hospitalmanagementsystem.patient.dto;

import lombok.Data;

@Data
public class PatientSaveRequestDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Long identityNo;
}
