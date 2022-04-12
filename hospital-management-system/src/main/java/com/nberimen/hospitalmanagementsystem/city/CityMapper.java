package com.nberimen.hospitalmanagementsystem.city;

import com.nberimen.hospitalmanagementsystem.city.dto.CityDto;
import com.nberimen.hospitalmanagementsystem.city.dto.CitySaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityMapper {
    CityMapper INCTANCE = Mappers.getMapper(CityMapper.class);

    List<CityDto> convertToCityDtoList(List<City> cityList);

    City convertToCity(CitySaveRequestDto citySaveRequestDto);

    CityDto convertToCityDto(City city);
}
