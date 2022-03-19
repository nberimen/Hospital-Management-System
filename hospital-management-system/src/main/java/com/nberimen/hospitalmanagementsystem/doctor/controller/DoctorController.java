package com.nberimen.hospitalmanagementsystem.doctor.controller;

import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.doctor.service.DoctorService;
import com.nberimen.hospitalmanagementsystem.gen.dto.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity findAll() {
        List<DoctorDto> doctorDtoList = doctorService.findAll();
        return ResponseEntity.ok(RestResponse.of(doctorDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        DoctorDto doctorDto = doctorService.findById(id);
        return ResponseEntity.ok(RestResponse.of(doctorDto));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody DoctorSaveRequestDto doctorSaveRequestDto) {
        DoctorDto doctorDto = doctorService.save(doctorSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(doctorDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        doctorService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

}
