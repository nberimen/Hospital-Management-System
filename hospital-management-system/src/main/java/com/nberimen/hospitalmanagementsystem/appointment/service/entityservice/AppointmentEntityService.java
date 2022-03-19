package com.nberimen.hospitalmanagementsystem.appointment.service.entityservice;

import com.nberimen.hospitalmanagementsystem.appointment.entity.Appointment;
import com.nberimen.hospitalmanagementsystem.appointment.repository.AppointmentRepository;
import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentEntityService extends BaseEntityService<Appointment, AppointmentRepository> {
    public AppointmentEntityService(AppointmentRepository repository) {
        super(repository);
    }
}
