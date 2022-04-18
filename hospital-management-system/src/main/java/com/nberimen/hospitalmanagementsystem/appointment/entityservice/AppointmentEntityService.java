package com.nberimen.hospitalmanagementsystem.appointment.entityservice;

import com.nberimen.hospitalmanagementsystem.appointment.Appointment;
import com.nberimen.hospitalmanagementsystem.appointment.AppointmentRepository;
import com.nberimen.hospitalmanagementsystem.appointment.enums.StatusType;
import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppointmentEntityService extends BaseEntityService<Appointment, AppointmentRepository> {
    public AppointmentEntityService(AppointmentRepository repository) {
        super(repository);
    }

    public List<Appointment> findAllByStatusTypeAndPatientIdAndDoctorId(StatusType statusType, Long patietnId, Long doctorId){
        return getRepository().findAllByStatusTypeAndPatientIdAndDoctorId(statusType, patietnId, doctorId);
    }

    public List<Appointment> findAllByPatientId(Long patientId){
        return getRepository().findAllByPatientId(patientId);
    }
}
