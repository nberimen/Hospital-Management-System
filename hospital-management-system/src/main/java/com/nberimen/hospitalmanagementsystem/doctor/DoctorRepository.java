package com.nberimen.hospitalmanagementsystem.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByIdentityNo(Long identityNo);
    List<Doctor> findAllByDepartmentId(Long departmentId);

}
