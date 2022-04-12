package com.nberimen.hospitalmanagementsystem.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByIdentityNo(Long identityNo);
}
