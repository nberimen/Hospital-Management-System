package com.nberimen.hospitalmanagementsystem.department;

import com.nberimen.hospitalmanagementsystem.department.dto.DepartmentDto;
import com.nberimen.hospitalmanagementsystem.department.dto.DepartmentSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.department.entityservice.DepartmentEntityService;
import com.nberimen.hospitalmanagementsystem.hospital.HospitalService;
import com.nberimen.hospitalmanagementsystem.hospital.dto.HospitalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentService {

    private final DepartmentEntityService departmentEntityService;
    private final HospitalService hospitalService;

    public List<DepartmentDto> findAll() {
        List<Department> departmentList = departmentEntityService.findAll();
        List<DepartmentDto> departmentDtoList = getDepartmentDtoList(departmentList);
        return departmentDtoList;
    }

    public List<DepartmentDto> findAllByHospitalId(Long hospitalId) {
        List<Department> departmentList = departmentEntityService.findAllByHospitalId(hospitalId);
        List<DepartmentDto> departmentDtoList = getDepartmentDtoList(departmentList);
        return departmentDtoList;
    }

    public DepartmentDto save(DepartmentSaveRequestDto departmentSaveRequestDto) {
        Department department = DepartmentMapper.INSTANCE.convertToDepartment(departmentSaveRequestDto);
        department = departmentEntityService.save(department);
        DepartmentDto departmentDto = DepartmentMapper.INSTANCE.convertToDepartmentDto(department);
        return departmentDto;
    }

    public DepartmentDto findById(Long id) {
        Department inDB = departmentEntityService.getById(id);
        HospitalDto hospitalDto = hospitalService.findById(inDB.getHospitalId());
        DepartmentDto departmentDto = DepartmentMapper.INSTANCE.convertToDepartmentDto(inDB);
        departmentDto.setHospitalDto(hospitalDto);
        return departmentDto;
    }

    public void delete(Long id) {
        Department inDB = departmentEntityService.getById(id);
        departmentEntityService.delete(inDB);
    }


    private List<DepartmentDto> getDepartmentDtoList(List<Department> departmentList) {
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        for (Department department : departmentList) {
            HospitalDto hospitalDto = hospitalService.findById(department.getHospitalId());
            DepartmentDto departmentDto = DepartmentMapper.INSTANCE.convertToDepartmentDto(department);
            departmentDto.setHospitalDto(hospitalDto);
            departmentDtoList.add(departmentDto);
        }
        return departmentDtoList;
    }
}
