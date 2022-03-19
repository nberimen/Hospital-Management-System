package com.nberimen.hospitalmanagementsystem.doctor.repository;

import com.nberimen.hospitalmanagementsystem.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
