package com.nberimen.hospitalmanagementsystem.patient.entityservice;

import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import com.nberimen.hospitalmanagementsystem.patient.Patient;
import com.nberimen.hospitalmanagementsystem.patient.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientEntityService extends BaseEntityService<Patient, PatientRepository> {

    public PatientEntityService(PatientRepository repository) {
        super(repository);
    }

    public Patient findByIdentityNo(Long identityNo) {
        return getRepository().findByIdentityNo(identityNo);
    }
}
