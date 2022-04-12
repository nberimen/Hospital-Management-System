package com.nberimen.hospitalmanagementsystem.patient.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PatientSaveRequestDto {

    @NotNull
    private Long identityNo;

    @NotNull
    @Size(min = 2, max = 255)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 255)
    private String lastName;

    @NotNull
    @Size(min = 2, max = 255)
    private String password;
}
