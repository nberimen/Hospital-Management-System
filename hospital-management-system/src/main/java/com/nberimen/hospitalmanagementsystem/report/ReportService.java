package com.nberimen.hospitalmanagementsystem.report;


import com.nberimen.hospitalmanagementsystem.doctor.DoctorService;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.patient.PatientService;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import com.nberimen.hospitalmanagementsystem.report.dto.ReportDto;
import com.nberimen.hospitalmanagementsystem.report.dto.ReportSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.report.entityservice.ReportEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportService {

    private final ReportEntityService reportEntityService;
    private final DoctorService doctorService;
    private final PatientService patientService;

    public List<ReportDto> findAll() {
        List<Report> reportList = reportEntityService.findAll();
        List<ReportDto> reportDtoList = getReportDtoList(reportList);
        return reportDtoList;
    }

    public List<ReportDto> findAllByPatientId(Long patientId) {
        List<Report> reportList = reportEntityService.findAllByPatientId(patientId);
        List<ReportDto> reportDtoList = getReportDtoList(reportList);
        return reportDtoList;
    }


    public ReportDto save(ReportSaveRequestDto reportSaveRequestDto) {
        Report report = ReportMapper.INSTANCE.convertToReport(reportSaveRequestDto);
        report.setDate(new Date());
        report = reportEntityService.save(report);
        ReportDto reportDto = ReportMapper.INSTANCE.convertToReportDto(report);
        return reportDto;
    }


    private List<ReportDto> getReportDtoList(List<Report> reportList) {
        List<ReportDto> reportDtoList = new ArrayList<>();
        for (Report report : reportList) {
            DoctorDto doctorDto = doctorService.findById(report.getDoctorId());
            PatientDto patientDto = patientService.findById(report.getPatientId());
            ReportDto reportDto = ReportMapper.INSTANCE.convertToReportDto(report);
            reportDto.setDoctorDto(doctorDto);
            reportDto.setPatientDto(patientDto);
            reportDtoList.add(reportDto);
        }
        return reportDtoList;
    }


}
