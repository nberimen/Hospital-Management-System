package com.nberimen.hospitalmanagementsystem.test;

import com.nberimen.hospitalmanagementsystem.test.dto.TestDto;
import com.nberimen.hospitalmanagementsystem.test.dto.TestSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestMapper {
    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);

    List<TestDto> convertToTestDtoList(List<Test> testList);

    TestDto convertToTestDto(Test test);

    Test convertToTest(TestSaveRequestDto testSaveRequestDto);
}
