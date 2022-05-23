package com.nberimen.hospitalmanagementsystem.appointment;

import com.nberimen.hospitalmanagementsystem.appointment.enums.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByStatusTypeAndPatientIdOrDoctorId(StatusType statusType, Long patietnId, Long doctorId);

    List<Appointment> findAllByPatientId(Long patientId);

    List<Appointment> findAllByDoctorId(Long doctorId);

    List<Appointment> findAllByStatusTypeAndPatientId(StatusType statusType, Long patientId);

    List<Appointment> findAllByStatusTypeAndDoctorId(StatusType statusType, Long doctorId);

}
