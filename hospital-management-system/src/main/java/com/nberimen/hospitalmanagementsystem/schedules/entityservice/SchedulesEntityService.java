package com.nberimen.hospitalmanagementsystem.schedules.entityservice;


import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import com.nberimen.hospitalmanagementsystem.schedules.Schedules;
import com.nberimen.hospitalmanagementsystem.schedules.SchedulesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SchedulesEntityService extends BaseEntityService<Schedules, SchedulesRepository> {
    public SchedulesEntityService(SchedulesRepository repository) {
        super(repository);
    }
}
