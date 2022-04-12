package com.nberimen.hospitalmanagementsystem.schedules.dto;

import lombok.Data;

@Data
public class SchedulesSaveRequestDto {

    private Long patientId;
    private Long doctorId;
    private String date;
    private String time;
}
