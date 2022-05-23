package com.nberimen.hospitalmanagementsystem.report.dto;

import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import lombok.Data;

import java.util.Date;

@Data
public class ReportDto {

    private Long id;

    private PatientDto patientDto;

    private DoctorDto doctorDto;

    private Date date;

    private String reportNo;

    private String reportType;

    private String diagnosis;
}
