package com.nberimen.hospitalmanagementsystem.city;

import com.nberimen.hospitalmanagementsystem.city.dto.CityDto;
import com.nberimen.hospitalmanagementsystem.city.dto.CitySaveRequestDto;
import com.nberimen.hospitalmanagementsystem.city.entityservice.CityEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CityService {

    private final CityEntityService cityEntityService;

    public List<CityDto> findAll() {
        List<City> cityList = cityEntityService.findAll();
        List<CityDto> cityDtoList = CityMapper.INCTANCE.convertToCityDtoList(cityList);
        return cityDtoList;
    }

    public CityDto save(CitySaveRequestDto citySaveRequestDto) {
        City city = CityMapper.INCTANCE.convertToCity(citySaveRequestDto);
        city = cityEntityService.save(city);
        CityDto cityDto = CityMapper.INCTANCE.convertToCityDto(city);
        return cityDto;
    }

    public CityDto findById(Long id) {
        City inDB = cityEntityService.getById(id);
        CityDto cityDto = CityMapper.INCTANCE.convertToCityDto(inDB);
        return cityDto;

    }

    public void delete(Long id) {
        City inDB = cityEntityService.getById(id);
        cityEntityService.delete(inDB);
    }

}
