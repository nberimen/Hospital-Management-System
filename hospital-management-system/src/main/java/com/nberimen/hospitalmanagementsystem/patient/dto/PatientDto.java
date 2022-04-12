package com.nberimen.hospitalmanagementsystem.patient.dto;

import lombok.Data;

@Data
public class PatientDto {

    private Long id;
    private Long identityNo;
    private String firstName;
    private String lastName;
    private String role;

}
