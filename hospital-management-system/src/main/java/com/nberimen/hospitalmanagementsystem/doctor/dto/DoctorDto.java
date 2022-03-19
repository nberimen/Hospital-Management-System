package com.nberimen.hospitalmanagementsystem.doctor.dto;

import lombok.Data;

@Data
public class DoctorDto {

    private Long id;
    private Long hospitalId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String branch;
}
