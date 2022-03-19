package com.nberimen.hospitalmanagementsystem.doctor.service.entityservice;

import com.nberimen.hospitalmanagementsystem.doctor.entity.Doctor;
import com.nberimen.hospitalmanagementsystem.doctor.repository.DoctorRepository;
import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class DoctorEntityService extends BaseEntityService<Doctor, DoctorRepository> {

    public DoctorEntityService(DoctorRepository repository) {
        super(repository);
    }

}
