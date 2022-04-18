package com.nberimen.hospitalmanagementsystem.hospital.entityservice;

import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import com.nberimen.hospitalmanagementsystem.hospital.Hospital;
import com.nberimen.hospitalmanagementsystem.hospital.HospitalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HospitalEntityService extends BaseEntityService<Hospital, HospitalRepository> {

    public HospitalEntityService(HospitalRepository repository) {
        super(repository);
    }

    public List<Hospital> findAllByCityId(Long cityId){
        return getRepository().findAllByCityId(cityId);
    }
}
