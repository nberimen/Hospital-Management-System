package com.nberimen.hospitalmanagementsystem.test.dto;

import lombok.Data;

@Data
public class TestSaveRequestDto {


    private Long patientId;

    private Long doctorId;

    private String processName;

    private String result;

    private String resultUnit;

    private String referenceValue;
}
