package com.nberimen.hospitalmanagementsystem.department.dto;

import lombok.Data;

@Data
public class DepartmentSaveRequestDto {

    private Long hospitalId;
    private String name;
}
