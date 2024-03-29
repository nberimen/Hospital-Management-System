package com.nberimen.hospitalmanagementsystem.department.entityservice;

import com.nberimen.hospitalmanagementsystem.department.Department;
import com.nberimen.hospitalmanagementsystem.department.DepartmentRepository;
import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentEntityService extends BaseEntityService<Department, DepartmentRepository> {

    public DepartmentEntityService(DepartmentRepository repository) {
        super(repository);
    }

    public List<Department> findAllByHospitalId(Long hospitalId) {
        return getRepository().findAllByHospitalId(hospitalId);
    }

}
