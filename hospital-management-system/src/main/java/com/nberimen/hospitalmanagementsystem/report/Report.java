package com.nberimen.hospitalmanagementsystem.report;

import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "REPORTS")
public class Report extends BaseEntity {


    @Column(name = "ID_PATIENT", nullable = false)
    private Long patientId;

    @Column(name = "ID_DOCTOR", nullable = false)
    private Long doctorId;

    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "REPORT_NO", length = 50, nullable = false)
    private String reportNo;

    @Column(name = "REPORT_TYPE", length = 50, nullable = false)
    private String reportType;

    @Column(name = "DIAGNOSIS", length = 50, nullable = false)
    private String diagnosis;


}
