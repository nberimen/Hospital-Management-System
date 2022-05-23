package com.nberimen.hospitalmanagementsystem.report;

import com.nberimen.hospitalmanagementsystem.report.dto.ReportDto;
import com.nberimen.hospitalmanagementsystem.report.dto.ReportSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReportMapper {

    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    List<ReportDto> convertToReportDtoList(List<Report> reportList);

    ReportDto convertToReportDto(Report report);

    Report convertToReport(ReportSaveRequestDto reportSaveRequestDto);
}
