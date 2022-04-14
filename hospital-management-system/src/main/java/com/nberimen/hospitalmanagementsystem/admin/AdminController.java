package com.nberimen.hospitalmanagementsystem.admin;

import com.nberimen.hospitalmanagementsystem.admin.dto.AdminDto;
import com.nberimen.hospitalmanagementsystem.admin.dto.AdminSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.appointment.dto.AppointmentDto;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.gen.dto.RestResponse;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;


    /**************************ADMIN*****************************************/

    @PostMapping("/save-admin")
    public ResponseEntity save(@RequestBody AdminSaveRequestDto adminSaveRequestDto) {
        AdminDto adminDto = adminService.save(adminSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(adminDto));
    }


    /**************************DOCTOR*****************************************/

    @GetMapping("/find-all-doctor")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity findAllDoctor() {
        List<DoctorDto> doctorDtoList = adminService.findAllDoctor();
        return ResponseEntity.ok(RestResponse.of(doctorDtoList));
    }

    @PostMapping("/save-doctor")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity saveDoctor(@RequestBody DoctorSaveRequestDto doctorSaveRequestDto) {
        DoctorDto doctorDto = adminService.saveDoctor(doctorSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(doctorDto));
    }

    @DeleteMapping("/delete-doctor/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteDoctor(@PathVariable Long id) {
        adminService.deleteDoctor(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    /**************************PATIENT*****************************************/
    @GetMapping("/find-all-patient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity findAllPatient() {
        List<PatientDto> patientDtoList = adminService.findAllPatient();
        return ResponseEntity.ok(RestResponse.of(patientDtoList));
    }

    @GetMapping("/patient/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity findPatientById(@PathVariable Long id) {
        PatientDto patientDto = adminService.findPatientById(id);
        return ResponseEntity.ok(RestResponse.of(patientDto));
    }

    @DeleteMapping("/delete-patient/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity deletePatient(@PathVariable Long id) {
        adminService.deletePatient(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    /**************************APPOINTMENT*****************************************/
    @GetMapping("/find-all-appointment")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity findAllAppointment() {
        List<AppointmentDto> appointmentDtoList = adminService.findAllAppointment();
        return ResponseEntity.ok(RestResponse.of(appointmentDtoList));
    }

    @DeleteMapping("/delete-appointment/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteAppointment(@PathVariable Long id) {
        adminService.deleteAppointment(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
