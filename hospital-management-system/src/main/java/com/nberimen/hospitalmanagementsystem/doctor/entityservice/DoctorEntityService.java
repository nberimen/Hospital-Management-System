package com.nberimen.hospitalmanagementsystem.doctor.entityservice;

import com.nberimen.hospitalmanagementsystem.doctor.Doctor;
import com.nberimen.hospitalmanagementsystem.doctor.DoctorRepository;
import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DoctorEntityService extends BaseEntityService<Doctor, DoctorRepository> {

    public DoctorEntityService(DoctorRepository repository) {
        super(repository);
    }

    public Doctor findByIdentityNo(Long identityNo) {
        return getRepository().findByIdentityNo(identityNo);
    }

    public List<Doctor> findAllByDepartmentId(Long departmentId) {
        return getRepository().findAllByDepartmentId(departmentId);
    }
}
