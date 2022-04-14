package com.nberimen.hospitalmanagementsystem.doctor.dto;

import com.nberimen.hospitalmanagementsystem.department.dto.DepartmentDto;
import lombok.Data;

@Data
public class DoctorDto {

    private Long id;
    private Long identityNo;
    private String firstName;
    private String lastName;
    private DepartmentDto departmentDto;
    private String role;

}
