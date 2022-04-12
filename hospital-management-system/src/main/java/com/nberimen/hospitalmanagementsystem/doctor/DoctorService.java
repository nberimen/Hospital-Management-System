package com.nberimen.hospitalmanagementsystem.doctor;

import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.doctor.entityservice.DoctorEntityService;
import com.nberimen.hospitalmanagementsystem.user.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DoctorService {

    private final DoctorEntityService doctorEntityService;
    private final PasswordEncoder passwordEncoder;

    public List<DoctorDto> findAll() {
        List<Doctor> doctorList = doctorEntityService.findAll();
        List<DoctorDto> doctorDtoList = DoctorMapper.INSTANCE.convertToDoctorDtoList(doctorList);
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
        DoctorDto doctorDto = DoctorMapper.INSTANCE.convertToDoctorDto(inDB);
        return doctorDto;
    }
}
