package com.nberimen.hospitalmanagementsystem.doctor;

import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoctorMapper {

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    List<DoctorDto> convertToDoctorDtoList(List<Doctor> doctorList);

    Doctor convertToDoctor(DoctorSaveRequestDto doctorSaveRequestDto);

    DoctorDto convertToDoctorDto(Doctor doctor);

}
