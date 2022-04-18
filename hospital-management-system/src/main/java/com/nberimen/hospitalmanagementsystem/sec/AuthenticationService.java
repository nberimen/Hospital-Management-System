package com.nberimen.hospitalmanagementsystem.sec;

import com.nberimen.hospitalmanagementsystem.admin.dto.AdminDto;
import com.nberimen.hospitalmanagementsystem.admin.dto.AdminSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.admin.AdminService;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.doctor.DoctorService;
import com.nberimen.hospitalmanagementsystem.gen.exceptions.AuthException;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.patient.PatientService;
import com.nberimen.hospitalmanagementsystem.sec.dto.SecLoginRequestDto;
import com.nberimen.hospitalmanagementsystem.sec.dto.SecAuthResponseDto;
import com.nberimen.hospitalmanagementsystem.sec.enums.EnumJwtConstant;
import com.nberimen.hospitalmanagementsystem.sec.security.JwtTokenGenerator;
import com.nberimen.hospitalmanagementsystem.sec.security.JwtUserDetails;
import com.nberimen.hospitalmanagementsystem.user.User;
import com.nberimen.hospitalmanagementsystem.user.UserRepository;
import com.nberimen.hospitalmanagementsystem.user.UserService;
import com.nberimen.hospitalmanagementsystem.user.enums.UserErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AdminService adminService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;
    private final PasswordEncoder passwordEncoder;


    public AdminDto registerAdmin(AdminSaveRequestDto adminSaveRequestDto) {
        return adminService.save(adminSaveRequestDto);
    }

    public PatientDto registerPatient(PatientSaveRequestDto patientSaveRequestDto) {
        return patientService.save(patientSaveRequestDto);
    }

    public DoctorDto registerDoctor(DoctorSaveRequestDto doctorSaveRequestDto) {
        return doctorService.save(doctorSaveRequestDto);
    }

    public SecAuthResponseDto login(SecLoginRequestDto secLoginRequestDto) {

        User inDB = userRepository.findByIdentityNo(secLoginRequestDto.getIdentityNo());
        if (inDB == null) {
            throw new AuthException(UserErrorMessage.UNAUTHORIZED_ERROR_MESSAGE);
        }
        boolean matches = passwordEncoder.matches(secLoginRequestDto.getPassword(), inDB.getPassword());
        if (!matches) {
            throw new AuthException(UserErrorMessage.UNAUTHORIZED_ERROR_MESSAGE);
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(secLoginRequestDto.getIdentityNo().toString(), secLoginRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenGenerator.generateJwtToken(authentication);
        String fullToken = EnumJwtConstant.BEARER.getConstant() + token;
        return getSecLoginResponseDto(authentication, fullToken);

    }

    private SecAuthResponseDto getSecLoginResponseDto(Authentication authentication, String fullToken) {
        SecAuthResponseDto secLoginResponseDto = new SecAuthResponseDto();
        JwtUserDetails authenticationPrincipal = (JwtUserDetails) authentication.getPrincipal();
        String role = authenticationPrincipal.getAuthorities().iterator().next().toString();

        secLoginResponseDto.setIdentityNo(Long.parseLong(authenticationPrincipal.getUsername()));
        secLoginResponseDto.setId(authenticationPrincipal.getId());
        secLoginResponseDto.setToken(fullToken);
        secLoginResponseDto.setRole(role);

        return secLoginResponseDto;
    }

    public User getCurrenUser() {
        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();
        User user = null;
        if (jwtUserDetails != null) {
            user = userService.findByIdentityNo(Long.parseLong(jwtUserDetails.getUsername()));
        }
        return user;
    }

    private Long getCurrentUserId() {
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
