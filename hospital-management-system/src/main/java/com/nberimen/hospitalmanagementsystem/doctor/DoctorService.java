package com.nberimen.hospitalmanagementsystem.doctor;

import com.nberimen.hospitalmanagementsystem.department.DepartmentService;
import com.nberimen.hospitalmanagementsystem.department.dto.DepartmentDto;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.doctor.entityservice.DoctorEntityService;
import com.nberimen.hospitalmanagementsystem.user.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DoctorService {

    private final DoctorEntityService doctorEntityService;
    private final PasswordEncoder passwordEncoder;
    private final DepartmentService departmentService;

    public List<DoctorDto> findAll() {
        List<Doctor> doctorList = doctorEntityService.findAll();
        List<DoctorDto> doctorDtoList = getDoctorDtoList(doctorList);
        return doctorDtoList;
    }

    public  List<DoctorDto> findAllByDepartmentId(Long departmentId){
        List<Doctor> doctorList = doctorEntityService.findAllByDepartmentId(departmentId);
        List<DoctorDto> doctorDtoList = getDoctorDtoList(doctorList);
        return doctorDtoList;

    }

    public DoctorDto save(DoctorSaveRequestDto doctorSaveRequestDto) {
        Doctor doctor = DoctorMapper.INSTANCE.convertToDoctor(doctorSaveRequestDto);
        String password = passwordEncoder.encode(doctor.getPassword());
        doctor.setRole(Role.DOCTOR);
        doctor.setPassword(password);
        doctor = doctorEntityService.save(doctor);
        DoctorDto doctorDto = DoctorMapper.INSTANCE.convertToDoctorDto(doctor);
        return doctorDto;
    }

    public void delete(Long id) {
        Doctor inDB = doctorEntityService.getById(id);
        doctorEntityService.delete(inDB);
    }

    public DoctorDto findById(Long id) {
        Doctor inDB = doctorEntityService.getById(id);
        DepartmentDto departmentDto = departmentService.findById(inDB.getDepartmentId());
        DoctorDto doctorDto = DoctorMapper.INSTANCE.convertToDoctorDto(inDB);
        doctorDto.setDepartmentDto(departmentDto);
        return doctorDto;
    }

    private List<DoctorDto> getDoctorDtoList(List<Doctor> doctorList) {
        List<DoctorDto> doctorDtoList = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            DepartmentDto departmentDto = departmentService.findById(doctor.getDepartmentId());
            DoctorDto doctorDto = DoctorMapper.INSTANCE.convertToDoctorDto(doctor);
            doctorDto.setDepartmentDto(departmentDto);
            doctorDtoList.add(doctorDto);
        }
        return doctorDtoList;
    }
}
