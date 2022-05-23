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
    public ResponseEntity findAllByStatusTypeAndPatientIdOrDoctorId(@PathVariable Long patientId, @PathVariable Long doctorId) {
        List<AppointmentDto> appointmentDtoList = appointmentService.findAllByStatusTypeAndPatientIdOrDoctorId(StatusType.ACTIVE, patientId, doctorId);
        return ResponseEntity.ok(RestResponse.of(appointmentDtoList));
    }
    @GetMapping("/patient/{patientId}")
    public ResponseEntity findAllByPatientId(@PathVariable Long patientId) {
        List<AppointmentDto> appointmentDtoList = appointmentService.findAllByPatientId(patientId);
        return ResponseEntity.ok(RestResponse.of(appointmentDtoList));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity findAllByDoctorId(@PathVariable Long doctorId) {
        List<AppointmentDto> appointmentDtoList = appointmentService.findAllByDoctorId(doctorId);
        return ResponseEntity.ok(RestResponse.of(appointmentDtoList));
    }

    @GetMapping("/patient/{patientId}/{statusType}")
    public ResponseEntity findAllByStatusTypeAndPatientId(@PathVariable Long patientId, @PathVariable String statusType) {
        List<AppointmentDto> appointmentDtoList = appointmentService.findAllByStatusTypeAndPatientId(statusType, patientId);
        return ResponseEntity.ok(RestResponse.of(appointmentDtoList));
    }

    @GetMapping("/doctor/{doctorId}/{statusType}")
    public ResponseEntity findAllByStatusTypeAndDoctorId(@PathVariable Long doctorId, @PathVariable String statusType) {
        List<AppointmentDto> appointmentDtoList = appointmentService.findAllByStatusTypeAndDoctorId(statusType, doctorId);
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

    @PatchMapping("/cancel/{appointmentId}")
    public ResponseEntity cancel(@PathVariable Long appointmentId) {
        appointmentService.cancel(appointmentId);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
