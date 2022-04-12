package com.nberimen.hospitalmanagementsystem.city;

import com.nberimen.hospitalmanagementsystem.city.dto.CityDto;
import com.nberimen.hospitalmanagementsystem.city.dto.CitySaveRequestDto;
import com.nberimen.hospitalmanagementsystem.gen.dto.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity findAll() {
        List<CityDto> cityDtoList = cityService.findAll();
        return ResponseEntity.ok(RestResponse.of(cityDtoList));
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        CityDto cityDto = cityService.findById(id);
        return ResponseEntity.ok(RestResponse.of(cityDto));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CitySaveRequestDto citySaveRequestDto) {
        CityDto cityDto = cityService.save(citySaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(cityDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        cityService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

}
