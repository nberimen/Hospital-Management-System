package com.nberimen.hospitalmanagementsystem.patient.service.entityservice;

import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import com.nberimen.hospitalmanagementsystem.patient.entity.Patient;
import com.nberimen.hospitalmanagementsystem.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientEntityService extends BaseEntityService<Patient, PatientRepository> {

    public PatientEntityService(PatientRepository repository) {
        super(repository);
    }
}
