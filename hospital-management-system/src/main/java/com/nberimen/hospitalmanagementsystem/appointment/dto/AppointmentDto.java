package com.nberimen.hospitalmanagementsystem.appointment.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDto {

    private Long id;
    private Long patientId;
    private Long doctorId;
    private Date appointmentDate;
}
