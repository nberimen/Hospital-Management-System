package com.nberimen.hospitalmanagementsystem.hospital;

import com.nberimen.hospitalmanagementsystem.hospital.dto.HospitalDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    List<Hospital> findAllByCityId(Long cityId);

}
