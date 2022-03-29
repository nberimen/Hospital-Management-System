package com.nberimen.hospitalmanagementsystem.patient.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class PatientDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Long identityNo;

}
