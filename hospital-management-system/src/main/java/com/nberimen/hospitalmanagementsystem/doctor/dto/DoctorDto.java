package com.nberimen.hospitalmanagementsystem.doctor.dto;

import lombok.Data;

@Data
public class DoctorDto {

    private Long id;
    private Long identityNo;
    private String firstName;
    private String lastName;
    private Long departmentId;
    private String role;

}
