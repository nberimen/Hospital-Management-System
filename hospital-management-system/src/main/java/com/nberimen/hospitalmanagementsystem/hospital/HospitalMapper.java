package com.nberimen.hospitalmanagementsystem.hospital;

import com.nberimen.hospitalmanagementsystem.hospital.dto.HospitalDto;
import com.nberimen.hospitalmanagementsystem.hospital.dto.HospitalSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HospitalMapper {

    HospitalMapper INSTANCE = Mappers.getMapper(HospitalMapper.class);

    List<HospitalDto> convertToHospitalDtoList(List<Hospital> hospitalList);

    Hospital convertToHospital(HospitalSaveRequestDto hospitalSaveRequestDto);

    HospitalDto convertToHospitalDto(Hospital hospital);
}
