package com.nberimen.hospitalmanagementsystem.appointment.repository;

import com.nberimen.hospitalmanagementsystem.appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
