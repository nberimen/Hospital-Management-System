package com.nberimen.hospitalmanagementsystem.patient.repository;

import com.nberimen.hospitalmanagementsystem.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByIdentityNo(Long identityNo);
}
