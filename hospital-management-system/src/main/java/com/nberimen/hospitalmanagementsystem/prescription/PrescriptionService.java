package com.nberimen.hospitalmanagementsystem.prescription;

import com.nberimen.hospitalmanagementsystem.doctor.DoctorService;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.patient.PatientService;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import com.nberimen.hospitalmanagementsystem.prescription.dto.PrescriptionDto;
import com.nberimen.hospitalmanagementsystem.prescription.dto.PrescriptionSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.prescription.entityservice.PrescriptionEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PrescriptionService {

    private final PrescriptionEntityService prescriptionEntityService;
    private final DoctorService doctorService;
    private final PatientService patientService;

    public List<PrescriptionDto> findAllByPatientId(Long patientId) {
        List<Prescription> prescriptionList = prescriptionEntityService.findAllByPatientId(patientId);
        List<PrescriptionDto> prescriptionDtoList = getPrescriptionDtoList(prescriptionList);
        return prescriptionDtoList;
    }

    public PrescriptionDto save(PrescriptionSaveRequestDto prescriptionSaveRequestDto) {
        Prescription prescription = PrescriptionMapper.INSTANCE.convertToPrescription(prescriptionSaveRequestDto);
        prescription.setPrescriptionDate(new Date());
        prescription = prescriptionEntityService.save(prescription);
        PrescriptionDto prescriptionDto = PrescriptionMapper.INSTANCE.convertToPrescriptionDto(prescription);
        return prescriptionDto;
    }

    public PrescriptionDto findById(Long prescriptionId) {
        Prescription prescription = prescriptionEntityService.getById(prescriptionId);
        DoctorDto doctorDto = doctorService.findById(prescription.getDoctorId());
        PatientDto patientDto = patientService.findById(prescription.getPatientId());
        PrescriptionDto prescriptionDto = PrescriptionMapper.INSTANCE.convertToPrescriptionDto(prescription);
        prescriptionDto.setDoctorDto(doctorDto);
        prescriptionDto.setPatientDto(patientDto);
        return prescriptionDto;
    }

    private List<PrescriptionDto> getPrescriptionDtoList(List<Prescription> prescriptionList) {
        List<PrescriptionDto> prescriptionDtoList = new ArrayList<>();

        for (Prescription prescription : prescriptionList) {
            DoctorDto doctorDto = doctorService.findById(prescription.getDoctorId());
            PatientDto patientDto = patientService.findById(prescription.getPatientId());
            PrescriptionDto prescriptionDto = PrescriptionMapper.INSTANCE.convertToPrescriptionDto(prescription);
            prescriptionDto.setDoctorDto(doctorDto);
            prescriptionDto.setPatientDto(patientDto);
            prescriptionDtoList.add(prescriptionDto);
        }
        return prescriptionDtoList;
    }
}
