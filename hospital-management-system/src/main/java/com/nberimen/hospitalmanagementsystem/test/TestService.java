package com.nberimen.hospitalmanagementsystem.test;

import com.nberimen.hospitalmanagementsystem.doctor.DoctorService;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorDto;
import com.nberimen.hospitalmanagementsystem.patient.PatientService;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientDto;
import com.nberimen.hospitalmanagementsystem.test.dto.TestDto;
import com.nberimen.hospitalmanagementsystem.test.dto.TestSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.test.entityservice.TestEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TestService {

    private final TestEntityService testEntityService;
    private final DoctorService doctorService;
    private final PatientService patientService;


    public List<TestDto> findAll() {
        List<Test> testList = testEntityService.findAll();
        List<TestDto> testDtoList = getTestDtoList(testList);
        return testDtoList;
    }

    public List<TestDto> findAllByPatientId(Long patientId) {
        List<Test> testList = testEntityService.findAllByPatientId(patientId);
        List<TestDto> testDtoList = getTestDtoList(testList);
        return testDtoList;
    }


    public TestDto save(TestSaveRequestDto testSaveRequestDto) {
        Test test = TestMapper.INSTANCE.convertToTest(testSaveRequestDto);
        test.setDate(new Date());
        test = testEntityService.save(test);
        TestDto testDto = TestMapper.INSTANCE.convertToTestDto(test);
        return testDto;
    }


    private List<TestDto> getTestDtoList(List<Test> testList) {
        List<TestDto> testDtoList = new ArrayList<>();
        for (Test test : testList) {
            DoctorDto doctorDto = doctorService.findById(test.getDoctorId());
            PatientDto patientDto = patientService.findById(test.getPatientId());
            TestDto testDto = TestMapper.INSTANCE.convertToTestDto(test);
            testDto.setDoctorDto(doctorDto);
            testDto.setPatientDto(patientDto);
            testDtoList.add(testDto);
        }
        return testDtoList;
    }

}
