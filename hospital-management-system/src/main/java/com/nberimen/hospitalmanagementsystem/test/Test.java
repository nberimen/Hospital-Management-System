package com.nberimen.hospitalmanagementsystem.test;

import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "TESTS")
public class Test extends BaseEntity {


    @Column(name = "ID_PATIENT", nullable = false)
    private Long patientId;

    @Column(name = "ID_DOCTOR", nullable = false)
    private Long doctorId;

    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "PROCESS_NAME", length = 50, nullable = false)
    private String processName;

    @Column(name = "RESULT", length = 50, nullable = false)
    private String result;

    @Column(name = "RESULT_UNIT", length = 50, nullable = false)
    private String resultUnit;

    @Column(name = "REFERENCE_VALUE", length = 50, nullable = false)
    private String referenceValue;



}
