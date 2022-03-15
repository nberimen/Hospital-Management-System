package com.nberimen.hospitalmanagementsystem.patient.converter;

import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.patient.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient convertToPatient(PatientDto patientDto);

    Patient convertToPatient(PatientSaveRequestDto patientSaveRequestDto);

    PatientDto convertToPatientDto(Patient patient);

    List<PatientDto> convertToPatientDtoList(List<Patient> patientList);
}
