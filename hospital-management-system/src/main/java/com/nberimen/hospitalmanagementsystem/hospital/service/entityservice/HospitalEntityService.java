package com.nberimen.hospitalmanagementsystem.hospital.service.entityservice;

import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import com.nberimen.hospitalmanagementsystem.hospital.entity.Hospital;
import com.nberimen.hospitalmanagementsystem.hospital.repository.HospitalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HospitalEntityService extends BaseEntityService<Hospital, HospitalRepository> {

    public HospitalEntityService(HospitalRepository repository) {
        super(repository);
    }
}
