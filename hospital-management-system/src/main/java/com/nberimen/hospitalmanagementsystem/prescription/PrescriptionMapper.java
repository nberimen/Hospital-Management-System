package com.nberimen.hospitalmanagementsystem.prescription;

import com.nberimen.hospitalmanagementsystem.prescription.dto.PrescriptionDto;
import com.nberimen.hospitalmanagementsystem.prescription.dto.PrescriptionSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrescriptionMapper {
    PrescriptionMapper INSTANCE = Mappers.getMapper(PrescriptionMapper.class);

    List<PrescriptionDto> convertToPrescriptionDtoList(List<Prescription> prescriptionList);

    PrescriptionDto convertToPrescriptionDto(Prescription prescription);

    Prescription convertToPrescription(PrescriptionSaveRequestDto prescriptionSaveRequestDto);
}
