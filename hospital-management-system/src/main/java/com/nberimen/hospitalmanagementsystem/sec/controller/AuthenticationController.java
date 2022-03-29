package com.nberimen.hospitalmanagementsystem.sec.controller;

import com.nberimen.hospitalmanagementsystem.gen.dto.RestResponse;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.sec.dto.SecLoginRequestDto;
import com.nberimen.hospitalmanagementsystem.sec.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(tags = "Authentication Controller")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody SecLoginRequestDto secLoginRequestDto) {

        String token = authenticationService.login(secLoginRequestDto);
        return ResponseEntity.ok(RestResponse.of(token));
    }

    @Operation(tags = "Authentication Controller")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody PatientSaveRequestDto patientSaveRequestDto) {
        PatientDto patientDto = authenticationService.register(patientSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(patientDto));
    }
}
