package com.nberimen.hospitalmanagementsystem.sec;

import com.nberimen.hospitalmanagementsystem.admin.dto.AdminDto;
import com.nberimen.hospitalmanagementsystem.admin.dto.AdminSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.gen.dto.RestResponse;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.sec.dto.SecLoginRequestDto;
import com.nberimen.hospitalmanagementsystem.sec.dto.SecAuthResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(tags = "Authentication Controller")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody SecLoginRequestDto secLoginRequestDto) {
        SecAuthResponseDto secLoginResponseDto = authenticationService.login(secLoginRequestDto);
        return ResponseEntity.ok(RestResponse.of(secLoginResponseDto));
    }

    @Operation(tags = "Authentication Controller")
    @PostMapping("/registerAdmin")
    public ResponseEntity registerPatient(@Valid @RequestBody AdminSaveRequestDto adminSaveRequestDto) {
        AdminDto adminDto = authenticationService.registerAdmin(adminSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(adminDto));
    }

    @Operation(tags = "Authentication Controller")
    @PostMapping("/registerPatient")
    public ResponseEntity registerPatient(@Valid @RequestBody PatientSaveRequestDto patientSaveRequestDto) {
        PatientDto patientDto = authenticationService.registerPatient(patientSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(patientDto));
    }

    @Operation(tags = "Authentication Controller")
    @PostMapping("/registerDoctor")
    public ResponseEntity registerDoctor(@Valid @RequestBody DoctorSaveRequestDto doctorSaveRequestDto) {
        DoctorDto doctorDto = authenticationService.registerDoctor(doctorSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(doctorDto));
    }
}
