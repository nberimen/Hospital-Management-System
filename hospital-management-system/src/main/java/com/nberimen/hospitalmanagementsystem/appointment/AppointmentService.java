package com.nberimen.hospitalmanagementsystem.appointment;

import com.nberimen.hospitalmanagementsystem.appointment.dto.AppointmentDto;
import com.nberimen.hospitalmanagementsystem.appointment.dto.AppointmentSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.appointment.entityservice.AppointmentEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
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
