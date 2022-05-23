package com.nberimen.hospitalmanagementsystem.prescription.dto;

import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import lombok.Data;

import java.util.Date;

@Data
public class PrescriptionDto {
    private Long id;

    private PatientDto patientDto;

    private DoctorDto doctorDto;

    private String prescriptionNo;

    private Date prescriptionDate;
}
