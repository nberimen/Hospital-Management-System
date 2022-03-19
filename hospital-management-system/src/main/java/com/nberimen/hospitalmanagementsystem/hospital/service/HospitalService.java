package com.nberimen.hospitalmanagementsystem.hospital.service;

import com.nberimen.hospitalmanagementsystem.hospital.converter.HospitalMapper;
import com.nberimen.hospitalmanagementsystem.hospital.dto.HospitalDto;
import com.nberimen.hospitalmanagementsystem.hospital.dto.HospitalSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.hospital.entity.Hospital;
import com.nberimen.hospitalmanagementsystem.hospital.service.entityservice.HospitalEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalEntityService hospitalEntityService;

    public List<HospitalDto> findAll() {
        List<Hospital> hospitalList = hospitalEntityService.findAll();
        List<HospitalDto> hospitalDtoList = HospitalMapper.INSTANCE.convertToHospitalDtoList(hospitalList);
        return hospitalDtoList;
    }

    public HospitalDto save(HospitalSaveRequestDto hospitalSaveRequestDto) {
        Hospital hospital = HospitalMapper.INSTANCE.convertToHospital(hospitalSaveRequestDto);
        hospital = hospitalEntityService.save(hospital);
        HospitalDto hospitalDto = HospitalMapper.INSTANCE.convertToHospitalDto(hospital);
        return hospitalDto;
    }

    public HospitalDto findById(Long id) {
        Hospital inDB = hospitalEntityService.getById(id);
        HospitalDto hospitalDto = HospitalMapper.INSTANCE.convertToHospitalDto(inDB);
        return hospitalDto;
    }

    public void delete(Long id) {
        Hospital inDB = hospitalEntityService.getById(id);
        hospitalEntityService.delete(inDB);
    }

}
