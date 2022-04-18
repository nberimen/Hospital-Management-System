package com.nberimen.hospitalmanagementsystem.appointment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nberimen.hospitalmanagementsystem.appointment.enums.StatusType;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentSaveRequestDto {

    private Long patientId;
    private Long doctorId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;
    @JsonFormat(pattern = "HH:mm")
    private Date appointmentTime;
}
