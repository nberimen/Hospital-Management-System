package com.nberimen.hospitalmanagementsystem.sec.security;

import com.nberimen.hospitalmanagementsystem.patient.entity.Patient;
import com.nberimen.hospitalmanagementsystem.patient.service.entityservice.PatientEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final PatientEntityService patientEntityService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Long identityNo = Long.valueOf(username);
        Patient patient = patientEntityService.findByIdentityNo(identityNo);

        return JwtUserDetails.create(patient);
    }

    public UserDetails loadUserByUserName(Long id) {
        Patient patient = patientEntityService.getById(id);
        return JwtUserDetails.create(patient);
    }
}
