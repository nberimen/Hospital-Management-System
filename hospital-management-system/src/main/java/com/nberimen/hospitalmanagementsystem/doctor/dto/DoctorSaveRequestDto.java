package com.nberimen.hospitalmanagementsystem.doctor.dto;

import lombok.Data;

@Data
public class DoctorSaveRequestDto {

    private Long hospitalId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String branch;
}
