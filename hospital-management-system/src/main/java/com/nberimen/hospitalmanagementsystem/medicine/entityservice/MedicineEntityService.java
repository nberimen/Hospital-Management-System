package com.nberimen.hospitalmanagementsystem.medicine.entityservice;

import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import com.nberimen.hospitalmanagementsystem.medicine.Medicine;
import com.nberimen.hospitalmanagementsystem.medicine.MedicineRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicineEntityService extends BaseEntityService<Medicine, MedicineRepository> {
    public MedicineEntityService(MedicineRepository repository) {
        super(repository);
    }

    public List<Medicine> findAllByPrescriptionId(Long prescriptionId) {
        return getRepository().findAllByPrescriptionId(prescriptionId);
    }
}
