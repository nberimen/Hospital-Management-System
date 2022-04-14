package com.nberimen.hospitalmanagementsystem.appointment.dto;

import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDto {

    private Long id;
    private PatientDto patientDto;
    private DoctorDto doctorDto;
    private Date appointmentDate;
    private Date appointmentTime;
}
