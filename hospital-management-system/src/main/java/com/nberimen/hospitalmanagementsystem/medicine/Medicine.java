package com.nberimen.hospitalmanagementsystem.medicine;

import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "MEDICINE")
public class Medicine extends BaseEntity {

    @Column(name = "PRESCRIPTON_ID", nullable = false)
    private Long prescriptionId;

    @Column(name = "BARCODE", nullable = false)
    private Long barcode;

    @Column(name = "NAME", length =50, nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", length =50, nullable = false)
    private String description;

    @Column(name = "DOSE", nullable = false)
    private Long dose;

    @Column(name = "PERIOD", nullable = false)
    private Long period;

    @Column(name = "USAGE", length =50, nullable = false)
    private String usage;

    @Column(name = "USE_COUNT", nullable = false)
    private Long useCount;

    @Column(name = "NUMBER_OF_BOXES", nullable = false)
    private Long numberOfBoxes;
}
