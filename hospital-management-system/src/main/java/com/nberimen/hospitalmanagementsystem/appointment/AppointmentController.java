package com.nberimen.hospitalmanagementsystem.appointment;

import com.nberimen.hospitalmanagementsystem.appointment.dto.AppointmentDto;
import com.nberimen.hospitalmanagementsystem.appointment.dto.AppointmentSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.appointment.enums.StatusType;
import com.nberimen.hospitalmanagementsystem.gen.dto.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity findAll() {
        List<AppointmentDto> appointmentDtoList = appointmentService.findAll();
        return ResponseEntity.ok(RestResponse.of(appointmentDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        AppointmentDto appointmentDto = appointmentService.findById(id);
        return ResponseEntity.ok(RestResponse.of(appointmentDto));
    }
    @GetMapping("/active/{patientId}/{doctorId}")
    public ResponseEntity findAllByStatusTypeAndPatientIdAndDoctorId(@PathVariable Long patientId, @PathVariable Long doctorId) {
        List<AppointmentDto> appointmentDtoList = appointmentService.findAllByStatusTypeAndPatientIdAndDoctorId(StatusType.ACTIVE, patientId, doctorId);
        return ResponseEntity.ok(RestResponse.of(appointmentDtoList));
    }
    @GetMapping("/patient/{patientId}")
    public ResponseEntity findAllByPatientId(@PathVariable Long patientId) {
        List<AppointmentDto> appointmentDtoList = appointmentService.findAllByPatientId(patientId);
        return ResponseEntity.ok(RestResponse.of(appointmentDtoList));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody AppointmentSaveRequestDto appointmentSaveRequestDto) {
        AppointmentDto appointmentDto = appointmentService.save(appointmentSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(appointmentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        appointmentService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
