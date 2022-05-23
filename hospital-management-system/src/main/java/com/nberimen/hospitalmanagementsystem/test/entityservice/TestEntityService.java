package com.nberimen.hospitalmanagementsystem.test.entityservice;

import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import com.nberimen.hospitalmanagementsystem.test.Test;
import com.nberimen.hospitalmanagementsystem.test.TestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestEntityService extends BaseEntityService<Test, TestRepository> {
    public TestEntityService(TestRepository repository) {
        super(repository);
    }

    public List<Test> findAllByPatientId(Long patientId) {
        return getRepository().findAllByPatientId(patientId);
    }
}
