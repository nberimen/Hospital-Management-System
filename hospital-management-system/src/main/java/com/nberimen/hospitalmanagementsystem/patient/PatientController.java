package com.nberimen.hospitalmanagementsystem.patient;

import com.nberimen.hospitalmanagementsystem.gen.dto.RestResponse;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity findAll() {
        List<PatientDto> patientDtoList = patientService.findAll();
        return ResponseEntity.ok(RestResponse.of(patientDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        PatientDto patientDto = patientService.findById(id);
        return ResponseEntity.ok(RestResponse.of(patientDto));
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody PatientSaveRequestDto patientSaveRequestDto) {
        PatientDto patientDto = patientService.save(patientSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(patientDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
