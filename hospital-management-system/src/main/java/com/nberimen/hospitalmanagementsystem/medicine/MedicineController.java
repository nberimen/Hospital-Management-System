package com.nberimen.hospitalmanagementsystem.medicine;

import com.nberimen.hospitalmanagementsystem.gen.dto.RestResponse;
import com.nberimen.hospitalmanagementsystem.medicine.dto.MedicineDto;
import com.nberimen.hospitalmanagementsystem.medicine.dto.MedicineSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/meds")
public class MedicineController {

    private final MedicineService medicineService;

    @GetMapping("/prescription/{prescriptionId}")
    public ResponseEntity findAllByPrescriptionId(@PathVariable Long prescriptionId) {
        List<MedicineDto> medicineDtoList = medicineService.findAllByPrescriptionId(prescriptionId);
        return ResponseEntity.ok(RestResponse.of(medicineDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        MedicineDto medicineDto = medicineService.findById(id);
        return ResponseEntity.ok(RestResponse.of(medicineDto));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody MedicineSaveRequestDto medicineSaveRequestDto) {
        MedicineDto medicineDto = medicineService.save(medicineSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(medicineDto));
    }
}
