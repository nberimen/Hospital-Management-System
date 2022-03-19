package com.nberimen.hospitalmanagementsystem.appointment.service;

import com.nberimen.hospitalmanagementsystem.appointment.converter.AppointmentMapper;
import com.nberimen.hospitalmanagementsystem.appointment.dto.AppointmentDto;
import com.nberimen.hospitalmanagementsystem.appointment.dto.AppointmentSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.appointment.entity.Appointment;
import com.nberimen.hospitalmanagementsystem.appointment.service.entityservice.AppointmentEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentEntityService appointmentEntityService;

    public List<AppointmentDto> findAll() {
        List<Appointment> appointmentList = appointmentEntityService.findAll();
        List<AppointmentDto> appointmentDtoList = AppointmentMapper.INSTANCE.convertToAppointmentDtoList(appointmentList);
        return appointmentDtoList;
    }

    public AppointmentDto save(AppointmentSaveRequestDto appointmentSaveRequestDto) {
        Appointment appointment = AppointmentMapper.INSTANCE.convetToAppointment(appointmentSaveRequestDto);
        appointmentEntityService.save(appointment);
        AppointmentDto appointmentDto = AppointmentMapper.INSTANCE.convertToAppointmentDto(appointment);
        return appointmentDto;
    }

    public AppointmentDto findById(Long id) {
        Appointment inDB = appointmentEntityService.getById(id);
        AppointmentDto appointmentDto = AppointmentMapper.INSTANCE.convertToAppointmentDto(inDB);
        return appointmentDto;
    }

    public void delete(Long id) {
        Appointment inDB = appointmentEntityService.getById(id);
        appointmentEntityService.delete(inDB);
    }


}
