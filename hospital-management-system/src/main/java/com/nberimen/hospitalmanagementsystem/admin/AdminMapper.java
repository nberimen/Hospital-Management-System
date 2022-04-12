package com.nberimen.hospitalmanagementsystem.admin;

import com.nberimen.hospitalmanagementsystem.admin.dto.AdminDto;
import com.nberimen.hospitalmanagementsystem.admin.dto.AdminSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Admin convertToAdmin(AdminSaveRequestDto adminSaveRequestDto);
    AdminDto convertToAdminDto(Admin admin);
}
