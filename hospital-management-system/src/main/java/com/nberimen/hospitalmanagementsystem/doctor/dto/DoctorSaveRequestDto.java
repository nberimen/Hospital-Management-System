package com.nberimen.hospitalmanagementsystem.doctor.dto;

import lombok.Data;

@Data
public class DoctorSaveRequestDto {

    private Long identityNo;
    private String firstName;
    private String lastName;
    private String password;
    private Long departmentId;
}
