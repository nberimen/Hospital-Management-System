package com.nberimen.hospitalmanagementsystem.prescription.entityservice;

import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import com.nberimen.hospitalmanagementsystem.prescription.Prescription;
import com.nberimen.hospitalmanagementsystem.prescription.PrescriptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrescriptionEntityService extends BaseEntityService<Prescription, PrescriptionRepository> {
    public PrescriptionEntityService(PrescriptionRepository repository) {
        super(repository);
    }

    public List<Prescription> findAllByPatientId(Long patientId) {
        return getRepository().findAllByPatientId(patientId);
    }
}
