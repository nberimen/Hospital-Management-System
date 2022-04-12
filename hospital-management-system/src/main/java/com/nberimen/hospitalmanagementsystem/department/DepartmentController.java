package com.nberimen.hospitalmanagementsystem.department;

import com.nberimen.hospitalmanagementsystem.department.dto.DepartmentDto;
import com.nberimen.hospitalmanagementsystem.department.dto.DepartmentSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.gen.dto.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity save(@RequestBody DepartmentSaveRequestDto departmentSaveRequestDto) {
        DepartmentDto departmentDto = departmentService.save(departmentSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(departmentDto));
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<DepartmentDto> departmentDtoList = departmentService.findAll();
        return ResponseEntity.ok(RestResponse.of(departmentDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        DepartmentDto departmentDto = departmentService.findById(id);
        return ResponseEntity.ok(RestResponse.of(departmentDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        departmentService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }


}
