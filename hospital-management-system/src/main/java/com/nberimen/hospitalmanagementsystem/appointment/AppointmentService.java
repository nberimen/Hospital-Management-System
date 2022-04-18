package com.nberimen.hospitalmanagementsystem.appointment;

import com.nberimen.hospitalmanagementsystem.appointment.dto.AppointmentDto;
import com.nberimen.hospitalmanagementsystem.appointment.dto.AppointmentSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.appointment.entityservice.AppointmentEntityService;
import com.nberimen.hospitalmanagementsystem.appointment.enums.StatusType;
import com.nberimen.hospitalmanagementsystem.doctor.DoctorService;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.patient.PatientService;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentService {
    private final AppointmentEntityService appointmentEntityService;
    private final DoctorService doctorService;
    private final PatientService patientService;

    public List<AppointmentDto> findAll() {
        List<Appointment> appointmentList = appointmentEntityService.findAll();
        List<AppointmentDto> appointmentDtoList = getAppointmentDtoList(appointmentList);
        return appointmentDtoList;
    }

    public List<AppointmentDto> findAllByStatusTypeAndPatientIdAndDoctorId(StatusType statusType, Long patietnId, Long doctorId) {
        List<Appointment> appointmentList = appointmentEntityService.findAllByStatusTypeAndPatientIdAndDoctorId(statusType, patietnId, doctorId);
        List<AppointmentDto> appointmentDtoList = getAppointmentDtoList(appointmentList);
        return appointmentDtoList;
    }

    public List<AppointmentDto> findAllByPatientId(Long patientId) {
        List<Appointment> appointmentList = appointmentEntityService.findAllByPatientId(patientId);
        List<AppointmentDto> appointmentDtoList = getAppointmentDtoList(appointmentList);
        return appointmentDtoList;
    }

    public AppointmentDto save(AppointmentSaveRequestDto appointmentSaveRequestDto) {
        Appointment appointment = AppointmentMapper.INSTANCE.convetToAppointment(appointmentSaveRequestDto);
        appointment.setStatusType(StatusType.ACTIVE);
        appointment = appointmentEntityService.save(appointment);
        AppointmentDto appointmentDto = AppointmentMapper.INSTANCE.convertToAppointmentDto(appointment);
        return appointmentDto;
    }

    public AppointmentDto findById(Long id) {
        Appointment inDB = appointmentEntityService.getById(id);
        DoctorDto doctorDto = doctorService.findById(inDB.getDoctorId());
        PatientDto patientDto = patientService.findById(inDB.getPatientId());
        AppointmentDto appointmentDto = AppointmentMapper.INSTANCE.convertToAppointmentDto(inDB);
        appointmentDto.setDoctorDto(doctorDto);
        appointmentDto.setPatientDto(patientDto);
        return appointmentDto;
    }

    public void delete(Long id) {
        Appointment inDB = appointmentEntityService.getById(id);
        appointmentEntityService.delete(inDB);
    }


    private List<AppointmentDto> getAppointmentDtoList(List<Appointment> appointmentList) {
        List<AppointmentDto> appointmentDtoList = new ArrayList<>();

        for (Appointment appointment : appointmentList) {
            DoctorDto doctorDto = doctorService.findById(appointment.getDoctorId());
            PatientDto patientDto = patientService.findById(appointment.getPatientId());
            AppointmentDto appointmentDto = AppointmentMapper.INSTANCE.convertToAppointmentDto(appointment);
            appointmentDto.setDoctorDto(doctorDto);
            appointmentDto.setPatientDto(patientDto);
            appointmentDtoList.add(appointmentDto);
        }
        return appointmentDtoList;
    }


}
