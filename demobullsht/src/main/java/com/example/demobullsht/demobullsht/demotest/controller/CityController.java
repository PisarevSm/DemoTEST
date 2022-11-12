package com.example.demobullsht.demobullsht.demotest.controller;

import com.example.demobullsht.demobullsht.booking.entity.WorkPlaceEntity;
import com.example.demobullsht.demobullsht.demotest.dto.CityDto;
import com.example.demobullsht.demobullsht.demotest.entity.CityEntity;
import com.example.demobullsht.demobullsht.demotest.mapper.CityMapper;
import com.example.demobullsht.demobullsht.demotest.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;


    @GetMapping("/")
    public List<CityDto> getCity() {
        List<CityEntity> cityEntity = cityService.getCity();
        return cityEntity.stream()
                .map(CityMapper::mapCityEntityToDto)
                .toList();
    }

    @GetMapping("/{id}")
    public CityDto getFindById(@PathVariable Long id) {
        return CityMapper.mapCityEntityToDto(cityService.getCityById(id));
    }

    @GetMapping("/get")
    public ResponseEntity<CityDto> getFindByCityName(
            @RequestParam(required = true) String CityName) {
        if (CityName == null) {
            throw new RuntimeException("Город с данным названием не найден");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    CityMapper.mapCityEntityToDto
                            (cityService.getCityByCityName(CityName));
        }
    }

    @PostMapping
    public void addNewCity(@RequestBody CityEntity cityEntity) {
        cityService.addNewCityEntity(cityEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteCityEntity(@PathVariable Long id) {
        cityService.deleteCityEntity(id);
    }
    // добавить 201 код (Место создано)
    @PutMapping("/{id}")
    public void updateCityEntity(
            @PathVariable Long id,
            @RequestParam(required = false) String CityName) {
        cityService.updateCityEntity(id, CityName);
    }
}
