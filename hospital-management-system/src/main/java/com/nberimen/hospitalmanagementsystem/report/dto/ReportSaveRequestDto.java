package com.nberimen.hospitalmanagementsystem.report.dto;

import lombok.Data;

@Data
public class ReportSaveRequestDto {

    private Long patientId;

    private Long doctorId;

    private String reportNo;

    private String reportType;

    private String diagnosis;
}
