package com.nberimen.hospitalmanagementsystem.hospital;

import com.nberimen.hospitalmanagementsystem.gen.dto.RestResponse;
import com.nberimen.hospitalmanagementsystem.hospital.dto.HospitalDto;
import com.nberimen.hospitalmanagementsystem.hospital.dto.HospitalSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService hospitalService;

    @GetMapping
    public ResponseEntity findAll() {
        List<HospitalDto> hospitalDtoList = hospitalService.findAll();
        return ResponseEntity.ok(RestResponse.of(hospitalDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        HospitalDto hospitalDto = hospitalService.findById(id);
        return ResponseEntity.ok(RestResponse.of(hospitalDto));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody HospitalSaveRequestDto hospitalSaveRequestDto) {
        HospitalDto hospitalDto = hospitalService.save(hospitalSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(hospitalDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        hospitalService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
