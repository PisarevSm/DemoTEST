package com.example.demobullsht.demotest.controller;

import java.util.*;

import com.example.demobullsht.demotest.dto.*;
import com.example.demobullsht.demotest.entity.*;
import com.example.demobullsht.demotest.mapper.*;
import com.example.demobullsht.demotest.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    private final CityMapper cityMapper;

    @PostMapping("/")
    public ResponseEntity<String> createCity(String newCityName) {
        cityService.addCity(newCityName);

        return ResponseEntity.ok("Город успешно создан.");
    }

    @GetMapping("/all")
    public ResponseEntity<List<CityDto>> getCity() {
        List<CityDto> cities;

        cities = cityService.getAll()
            .stream()
            .map(cityMapper::cityToDto)
            .toList();

        return ResponseEntity.ok(cities);
    }

    @GetMapping("/id{id}")
    public ResponseEntity<CityDto> getCityById(@PathVariable Long id) {
        return ResponseEntity.ok(cityMapper.cityToDto(cityService.getById(id))
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<CityDto> getCityByName(@PathVariable String name) {
        return ResponseEntity.ok(cityMapper.cityToDto(cityService.getByName(name))
        );
    }

    @PutMapping("/")
    public void updateCity(
        @PathVariable("cityId") Long id,
        @RequestBody CityDto cityDto
    ) {

        CityEntity cityEntity = cityService.getById(id);

        if (cityDto.getName() != null &&
            cityDto.getName().length() > 0 &&
            !Objects.equals(cityEntity.getName(), cityDto.getName())) {
            cityEntity.setName(cityDto.getName());
        }
        cityService.updateCity(cityEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);

        return ResponseEntity.ok("Город удален.");
    }

}
