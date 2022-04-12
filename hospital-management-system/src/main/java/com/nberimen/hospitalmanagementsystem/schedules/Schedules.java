package com.nberimen.hospitalmanagementsystem.schedules;

import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "SCHEDULES")
@Data
public class Schedules extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_PATIENT", nullable = false)
    private Long patientId;

    @Column(name = "ID_DOCTOR", nullable = false)
    private Long doctorId;

    @Column(name = "DATE")
    private String date;

    @Column(name = "TIME")
    private String time;
}
