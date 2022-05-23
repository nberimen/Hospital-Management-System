package com.nberimen.hospitalmanagementsystem.medicine.dto;

import com.nberimen.hospitalmanagementsystem.prescription.dto.PrescriptionDto;
import lombok.Data;

@Data
public class MedicineDto {
    private Long id;

    private PrescriptionDto prescriptionDto;

    private Long barcode;

    private String name;

    private String description;

    private Long dose;

    private Long period;

    private String usage;

    private Long useCount;

    private Long numberOfBoxes;
}
