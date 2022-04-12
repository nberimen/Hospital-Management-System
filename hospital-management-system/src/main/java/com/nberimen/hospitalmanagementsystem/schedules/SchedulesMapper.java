package com.nberimen.hospitalmanagementsystem.schedules;

import com.nberimen.hospitalmanagementsystem.schedules.dto.SchedulesDto;
import com.nberimen.hospitalmanagementsystem.schedules.dto.SchedulesSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SchedulesMapper {
    SchedulesMapper INSTANCE = Mappers.getMapper(SchedulesMapper.class);

    Schedules convertToSchedules(SchedulesSaveRequestDto schedulesSaveRequestDto);

    SchedulesDto convertToSchedulesDto(Schedules schedules);

    List<SchedulesDto> convertToSchedulesDtoList(List<Schedules> schedulesList);
}
