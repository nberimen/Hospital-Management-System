package com.nberimen.hospitalmanagementsystem.admin;

import com.nberimen.hospitalmanagementsystem.admin.dto.AdminDto;
import com.nberimen.hospitalmanagementsystem.admin.dto.AdminSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.admin.entityservice.AdminEntityService;
import com.nberimen.hospitalmanagementsystem.appointment.AppointmentService;
import com.nberimen.hospitalmanagementsystem.appointment.dto.AppointmentDto;
import com.nberimen.hospitalmanagementsystem.appointment.dto.AppointmentSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.doctor.DoctorService;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import com.nberimen.hospitalmanagementsystem.patient.PatientService;
import com.nberimen.hospitalmanagementsystem.user.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {

    private final AdminEntityService adminEntityService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final AppointmentService appointmentService;
    private final PasswordEncoder passwordEncoder;

    /*************************ADMIN****************************************/

    public AdminDto save(AdminSaveRequestDto adminSaveRequestDto) {
        Admin admin = AdminMapper.INSTANCE.convertToAdmin(adminSaveRequestDto);
        String password = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(password);
        admin.setRole(Role.ADMIN);
        admin = adminEntityService.save(admin);
        AdminDto adminDto = AdminMapper.INSTANCE.convertToAdminDto(admin);
        return adminDto;
    }


    /*************************PATIENT*************************************/

    public List<PatientDto> findAllPatient() {
        List<PatientDto> patientDtoList = patientService.findAll();
        return patientDtoList;
    }

    public void deletePatient(Long id) {
        patientService.delete(id);
    }

    /*************************DOCTOR*************************************/

    public List<DoctorDto> findAllDoctor() {
        List<DoctorDto> doctorDtoList = doctorService.findAll();
        return doctorDtoList;
    }

    public void deleteDoctor(Long id) {
        doctorService.delete(id);
    }

    public DoctorDto saveDoctor(DoctorSaveRequestDto doctorSaveRequestDto) {
        DoctorDto doctorDto = doctorService.save(doctorSaveRequestDto);
        return doctorDto;
    }

    /*************************APPOINTMENT*************************************/

    public List<AppointmentDto> findAllAppointment() {
        List<AppointmentDto> appointmentDtoList = appointmentService.findAll();
        return appointmentDtoList;
    }

    public void deleteAppointment(Long id) {
        appointmentService.delete(id);
    }

    public AppointmentDto saveAppointment(AppointmentSaveRequestDto appointmentSaveRequestDto) {
        AppointmentDto appointmentDto = appointmentService.save(appointmentSaveRequestDto);
        return appointmentDto;
    }

}
