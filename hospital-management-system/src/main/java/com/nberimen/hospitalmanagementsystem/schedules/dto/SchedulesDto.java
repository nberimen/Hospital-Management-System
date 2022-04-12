package com.nberimen.hospitalmanagementsystem.schedules.dto;

import lombok.Data;

@Data
public class SchedulesDto {

    private Long id;
    private Long patientId;
    private Long doctorId;
    private String date;
    private String time;
}
