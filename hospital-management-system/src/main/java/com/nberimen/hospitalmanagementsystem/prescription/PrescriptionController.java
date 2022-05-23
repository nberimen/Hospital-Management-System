package com.nberimen.hospitalmanagementsystem.prescription;

import com.nberimen.hospitalmanagementsystem.gen.dto.RestResponse;
import com.nberimen.hospitalmanagementsystem.prescription.dto.PrescriptionDto;
import com.nberimen.hospitalmanagementsystem.prescription.dto.PrescriptionSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @GetMapping("/{patientId}")
    public ResponseEntity findAllByPrescriptionId(@PathVariable Long patientId) {
        List<PrescriptionDto> prescriptionDtoList = prescriptionService.findAllByPatientId(patientId);
        return ResponseEntity.ok(RestResponse.of(prescriptionDtoList));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody PrescriptionSaveRequestDto prescriptionSaveRequestDto) {
        PrescriptionDto prescriptionDto = prescriptionService.save(prescriptionSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(prescriptionDto));
    }
}
