package com.nberimen.hospitalmanagementsystem.department;

import com.nberimen.hospitalmanagementsystem.department.dto.DepartmentDto;
import com.nberimen.hospitalmanagementsystem.department.dto.DepartmentSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.department.entityservice.DepartmentEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentService {

    private final DepartmentEntityService departmentEntityService;

    public List<DepartmentDto> findAll() {
        List<Department> departmentList = departmentEntityService.findAll();
        List<DepartmentDto> departmentDtoList = DepartmentMapper.INSTANCE.convertToDepartmentDtoList(departmentList);
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
        DepartmentDto departmentDto = DepartmentMapper.INSTANCE.convertToDepartmentDto(inDB);
        return departmentDto;
    }

    public void delete(Long id) {
        Department inDB = departmentEntityService.getById(id);
        departmentEntityService.delete(inDB);
    }
}
