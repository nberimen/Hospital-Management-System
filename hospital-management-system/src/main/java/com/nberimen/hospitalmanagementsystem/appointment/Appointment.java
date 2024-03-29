package com.nberimen.hospitalmanagementsystem.appointment;

import com.nberimen.hospitalmanagementsystem.appointment.enums.StatusType;
import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "APPOINTMENT")
@Data
public class Appointment extends BaseEntity {

    @Column(name = "ID_PATIENT", nullable = false)
    private Long patientId;

    @Column(name = "ID_DOCTOR", nullable = false)
    private Long doctorId;

    @Column(name = "APPOINTMENT_DATE")
    @Temporal(TemporalType.DATE)
    private Date appointmentDate;

    @Column(name = "APPOINTMENT_TIME")
    @Temporal(TemporalType.TIME)
    private Date appointmentTime;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS_TYPE", length = 30)
    private StatusType statusType;

}
