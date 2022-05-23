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

    public List<Appointment> findAllByStatusTypeAndPatientIdOrDoctorId(StatusType statusType, Long patietnId, Long doctorId) {
        return getRepository().findAllByStatusTypeAndPatientIdOrDoctorId(statusType, patietnId, doctorId);
    }

    public List<Appointment> findAllByPatientId(Long patientId) {
        return getRepository().findAllByPatientId(patientId);
    }

    public List<Appointment> findAllByDoctorId(Long doctorId) {
        return getRepository().findAllByDoctorId(doctorId);
    }

    public List<Appointment> findAllByStatusTypeAndPatientId(StatusType statusType, Long patientId) {
        return getRepository().findAllByStatusTypeAndPatientId(statusType, patientId);
    }

    public List<Appointment> findAllByStatusTypeAndDoctorId(StatusType statusType, Long doctorId) {
        return getRepository().findAllByStatusTypeAndDoctorId(statusType, doctorId);
    }
}
