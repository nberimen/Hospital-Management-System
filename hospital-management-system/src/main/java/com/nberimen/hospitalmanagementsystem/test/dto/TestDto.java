package com.nberimen.hospitalmanagementsystem.test.dto;

import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import lombok.Data;

import java.util.Date;

@Data
public class TestDto {

    private Long id;

    private PatientDto patientDto;

    private DoctorDto doctorDto;

    private Date date;

    private String processName;

    private String result;

    private String resultUnit;

    private String referenceValue;
}
