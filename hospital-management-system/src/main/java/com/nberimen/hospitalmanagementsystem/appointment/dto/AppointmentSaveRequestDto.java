package com.nberimen.hospitalmanagementsystem.appointment.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentSaveRequestDto {

    private Long patientId;
    private Long doctorId;
    private Date appointmentDate;
}
