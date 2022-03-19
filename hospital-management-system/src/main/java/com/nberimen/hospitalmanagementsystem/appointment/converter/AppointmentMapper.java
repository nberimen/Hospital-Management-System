package com.nberimen.hospitalmanagementsystem.appointment.converter;

import com.nberimen.hospitalmanagementsystem.appointment.dto.AppointmentDto;
import com.nberimen.hospitalmanagementsystem.appointment.dto.AppointmentSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.appointment.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppointmentMapper {

    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    List<AppointmentDto> convertToAppointmentDtoList(List<Appointment> appointmentList);

    AppointmentDto convertToAppointmentDto(Appointment appointment);

    Appointment convetToAppointment(AppointmentSaveRequestDto appointmentSaveRequestDto);
}
