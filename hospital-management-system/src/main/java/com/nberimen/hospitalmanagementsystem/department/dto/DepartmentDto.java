package com.nberimen.hospitalmanagementsystem.department.dto;

import com.nberimen.hospitalmanagementsystem.hospital.dto.HospitalDto;
import lombok.Data;

@Data
public class DepartmentDto {

    private Long id;
    private Long hospitalId;
    private String name;
    private HospitalDto hospitalDto;
}
