package com.nberimen.hospitalmanagementsystem.city.service.entityservice;

import com.nberimen.hospitalmanagementsystem.city.entity.City;
import com.nberimen.hospitalmanagementsystem.city.repository.CityRepository;
import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityEntityService extends BaseEntityService<City, CityRepository> {
    public CityEntityService(CityRepository repository) {
        super(repository);
    }
}
