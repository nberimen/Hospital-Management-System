package com.nberimen.hospitalmanagementsystem.schedules;

import com.nberimen.hospitalmanagementsystem.schedules.dto.SchedulesDto;
import com.nberimen.hospitalmanagementsystem.schedules.dto.SchedulesSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.schedules.entityservice.SchedulesEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SchedulesService {

    private final SchedulesEntityService schedulesEntityService;

    public SchedulesDto save(SchedulesSaveRequestDto schedulerSaveRequestDto) {
        Schedules schedules = SchedulesMapper.INSTANCE.convertToSchedules(schedulerSaveRequestDto);
        schedules = schedulesEntityService.save(schedules);
        SchedulesDto schedulesDto = SchedulesMapper.INSTANCE.convertToSchedulesDto(schedules);
        return schedulesDto;
    }

    public List<SchedulesDto> findAll() {
        List<Schedules> schedulesList = schedulesEntityService.findAll();
        List<SchedulesDto> schedulesDtoList = SchedulesMapper.INSTANCE.convertToSchedulesDtoList(schedulesList);
        return schedulesDtoList;
    }

    public void delete(Long id) {
        Schedules inDB = schedulesEntityService.getById(id);
        schedulesEntityService.delete(inDB);
    }

    public SchedulesDto findById(Long id) {
        Schedules inDB = schedulesEntityService.getById(id);
        SchedulesDto schedulesDto = SchedulesMapper.INSTANCE.convertToSchedulesDto(inDB);
        return schedulesDto;
    }
}
