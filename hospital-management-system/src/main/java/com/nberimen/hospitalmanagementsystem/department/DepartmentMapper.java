package com.nberimen.hospitalmanagementsystem.department;

import com.nberimen.hospitalmanagementsystem.department.dto.DepartmentDto;
import com.nberimen.hospitalmanagementsystem.department.dto.DepartmentSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.hospital.Hospital;
import com.nberimen.hospitalmanagementsystem.hospital.dto.HospitalDto;
import com.nberimen.hospitalmanagementsystem.hospital.dto.HospitalSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    List<DepartmentDto> convertToDepartmentDtoList(List<Department> departmentList);

    Department convertToDepartment(DepartmentSaveRequestDto departmentSaveRequestDto);

    DepartmentDto convertToDepartmentDto(Department department);
}
