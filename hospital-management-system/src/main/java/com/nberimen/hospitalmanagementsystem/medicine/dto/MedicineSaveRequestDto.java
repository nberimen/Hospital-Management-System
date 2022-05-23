package com.nberimen.hospitalmanagementsystem.medicine.dto;

import lombok.Data;

@Data
public class MedicineSaveRequestDto {

    private Long prescriptionId;

    private Long barcode;

    private String name;

    private String description;

    private Long dose;

    private Long period;

    private String usage;

    private Long useCount;

    private Long numberOfBoxes;
}
