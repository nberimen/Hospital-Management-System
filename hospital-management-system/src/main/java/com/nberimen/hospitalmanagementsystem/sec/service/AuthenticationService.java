package com.nberimen.hospitalmanagementsystem.sec.service;

import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.patient.entity.Patient;
import com.nberimen.hospitalmanagementsystem.patient.service.PatientService;
import com.nberimen.hospitalmanagementsystem.patient.service.entityservice.PatientEntityService;
import com.nberimen.hospitalmanagementsystem.sec.dto.SecLoginRequestDto;
import com.nberimen.hospitalmanagementsystem.sec.enums.EnumJwtConstant;
import com.nberimen.hospitalmanagementsystem.sec.security.JwtTokenGenerator;
import com.nberimen.hospitalmanagementsystem.sec.security.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PatientService patientService;
    private final PatientEntityService patientEntityService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;

    public PatientDto register(PatientSaveRequestDto patientSaveRequestDto) {
        return patientService.save(patientSaveRequestDto);
    }

    public String login(SecLoginRequestDto secLoginRequestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(secLoginRequestDto.getIdentityNo().toString(), secLoginRequestDto.getPassword().toString());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenGenerator.generateJwtToken(authentication);

        String bearer = EnumJwtConstant.BEARER.getConstant();
        return bearer + token;
    }

    public Patient getCurrenCustomer() {
        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();
        Patient patient = null;
        if (jwtUserDetails != null) {
            patient = patientEntityService.getById(jwtUserDetails.getId());
        }
        return patient;
    }

    private Long getCurrentCustomerId() {
        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();

        return jwtUserDetails.getId();
    }

    private JwtUserDetails getCurrentJwtUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JwtUserDetails jwtUserDetails = null;
        if (authentication != null && authentication.getPrincipal() instanceof JwtUserDetails) {
            jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();

        }
        return jwtUserDetails;
    }
}
