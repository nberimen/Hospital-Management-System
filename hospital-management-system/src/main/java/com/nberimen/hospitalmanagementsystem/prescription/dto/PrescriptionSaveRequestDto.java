package com.nberimen.hospitalmanagementsystem.prescription.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PrescriptionSaveRequestDto {

    private Long patientId;

    private Long doctorId;

    private String prescriptionNo;
}
