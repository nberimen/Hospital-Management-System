package com.nberimen.hospitalmanagementsystem.report.entityservice;

import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import com.nberimen.hospitalmanagementsystem.report.Report;
import com.nberimen.hospitalmanagementsystem.report.ReportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReportEntityService extends BaseEntityService<Report, ReportRepository> {
    public ReportEntityService(ReportRepository repository) {
        super(repository);
    }

    public List<Report> findAllByPatientId(Long patientId) {
        return getRepository().findAllByPatientId(patientId);
    }
}
