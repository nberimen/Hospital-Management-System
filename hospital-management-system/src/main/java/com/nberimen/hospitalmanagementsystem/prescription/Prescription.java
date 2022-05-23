package com.nberimen.hospitalmanagementsystem.prescription;

import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "PRESCRIPTION")
public class Prescription extends BaseEntity {

    @Column(name = "ID_PATIENT", nullable = false)
    private Long patientId;

    @Column(name = "ID_DOCTOR", nullable = false)
    private Long doctorId;

    @Column(name = "PRESCRIPTION_NO", length = 50, nullable = false)
    private String prescriptionNo;

    @Column(name = "PRESCRIPTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date prescriptionDate;
}
