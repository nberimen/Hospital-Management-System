package com.nberimen.hospitalmanagementsystem.patient.service;

import com.nberimen.hospitalmanagementsystem.patient.converter.PatientMapper;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.patient.entity.Patient;
import com.nberimen.hospitalmanagementsystem.patient.service.entityservice.PatientEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientService {

    private final PatientEntityService patientEntityService;
    private final PasswordEncoder passwordEncoder;

    public List<PatientDto> findAll() {
        List<Patient> patientList = patientEntityService.findAll();
        List<PatientDto> patientDtoList = PatientMapper.INSTANCE.convertToPatientDtoList(patientList);
        return patientDtoList;
    }

    public PatientDto save(PatientSaveRequestDto patientSaveRequestDto) {
        Patient patient = PatientMapper.INSTANCE.convertToPatient(patientSaveRequestDto);

        String password = passwordEncoder.encode(patient.getPassword());
        patient.setPassword(password);
        patient = patientEntityService.save(patient);
        PatientDto patientDto = PatientMapper.INSTANCE.convertToPatientDto(patient);
        return patientDto;
    }

    public void delete(Long id) {
        Patient inDB = patientEntityService.getById(id);
        patientEntityService.delete(inDB);
    }

    public PatientDto findById(Long id) {
        Patient inDB = patientEntityService.getById(id);
        PatientDto patientDto = PatientMapper.INSTANCE.convertToPatientDto(inDB);
        return patientDto;
    }

}
