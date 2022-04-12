package com.nberimen.hospitalmanagementsystem.schedules;

import com.nberimen.hospitalmanagementsystem.gen.dto.RestResponse;
import com.nberimen.hospitalmanagementsystem.schedules.dto.SchedulesDto;
import com.nberimen.hospitalmanagementsystem.schedules.dto.SchedulesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedules")
@RequiredArgsConstructor
public class SchedulesController {

    private final SchedulesService schedulesService;

    @PostMapping
    public ResponseEntity save(@RequestBody SchedulesSaveRequestDto schedulerSaveRequestDto) {
        SchedulesDto schedulesDto = schedulesService.save(schedulerSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(schedulesDto));
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<SchedulesDto> schedulesDtoList = schedulesService.findAll();
        return ResponseEntity.ok(RestResponse.of(schedulesDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        SchedulesDto schedulesDto = schedulesService.findById(id);
        return ResponseEntity.ok(RestResponse.of(schedulesDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        schedulesService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
