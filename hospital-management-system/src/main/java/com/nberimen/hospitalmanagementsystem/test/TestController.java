package com.nberimen.hospitalmanagementsystem.test;

import com.nberimen.hospitalmanagementsystem.gen.dto.RestResponse;
import com.nberimen.hospitalmanagementsystem.test.dto.TestDto;
import com.nberimen.hospitalmanagementsystem.test.dto.TestSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tests")
public class TestController {

    private final TestService testService;

    @GetMapping
    public ResponseEntity findAll() {
        List<TestDto> testDtoList = testService.findAll();
        return ResponseEntity.ok(RestResponse.of(testDtoList));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity findAllByPatientId(@PathVariable Long patientId) {
        List<TestDto> testDtoList = testService.findAllByPatientId(patientId);
        return ResponseEntity.ok(RestResponse.of(testDtoList));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody TestSaveRequestDto testSaveRequestDto) {
        TestDto testDto = testService.save(testSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(testDto));
    }
}
