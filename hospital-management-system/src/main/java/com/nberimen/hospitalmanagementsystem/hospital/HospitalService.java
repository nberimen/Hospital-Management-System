package com.nberimen.hospitalmanagementsystem.hospital;

import com.nberimen.hospitalmanagementsystem.hospital.dto.HospitalDto;
import com.nberimen.hospitalmanagementsystem.hospital.dto.HospitalSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.hospital.entityservice.HospitalEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HospitalService {

    private final HospitalEntityService hospitalEntityService;

    public List<HospitalDto> findAll() {
        List<Hospital> hospitalList = hospitalEntityService.findAll();
        List<HospitalDto> hospitalDtoList = HospitalMapper.INSTANCE.convertToHospitalDtoList(hospitalList);
        return hospitalDtoList;
    }
    public List<HospitalDto> findAllByCityId(Long cityId) {
        List<Hospital> hospitalList = hospitalEntityService.findAllByCityId(cityId);
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
