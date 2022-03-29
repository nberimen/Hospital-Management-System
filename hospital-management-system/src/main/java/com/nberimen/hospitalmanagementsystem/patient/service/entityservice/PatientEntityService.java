package com.nberimen.hospitalmanagementsystem.patient.service.entityservice;

import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import com.nberimen.hospitalmanagementsystem.patient.entity.Patient;
import com.nberimen.hospitalmanagementsystem.patient.repository.PatientRepository;
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
