package com.nberimen.hospitalmanagementsystem.report;

import com.nberimen.hospitalmanagementsystem.gen.dto.RestResponse;
import com.nberimen.hospitalmanagementsystem.report.dto.ReportDto;
import com.nberimen.hospitalmanagementsystem.report.dto.ReportSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reports")
public class ReportController {

    private final ReportService reportService;

    @GetMapping
    public ResponseEntity findAllBy() {
        List<ReportDto> reportDtoList = reportService.findAll();
        return ResponseEntity.ok(RestResponse.of(reportDtoList));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity findAllByPatientId(@PathVariable Long patientId) {
        List<ReportDto> reportDtoList = reportService.findAllByPatientId(patientId);
        return ResponseEntity.ok(RestResponse.of(reportDtoList));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ReportSaveRequestDto reportSaveRequestDto) {
        ReportDto reportDto = reportService.save(reportSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(reportDto));
    }
}
