package com.nberimen.hospitalmanagementsystem.medicine;

import com.nberimen.hospitalmanagementsystem.medicine.dto.MedicineDto;
import com.nberimen.hospitalmanagementsystem.medicine.dto.MedicineSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicineMapper {
    MedicineMapper INSTANCE = Mappers.getMapper(MedicineMapper.class);

    MedicineDto convertToMedicineDto(Medicine medicine);

    List<MedicineDto> convertToMedicineDtoList(List<Medicine> medicineList);

    Medicine convertToMedicine(MedicineSaveRequestDto medicineSaveRequestDto);
}
