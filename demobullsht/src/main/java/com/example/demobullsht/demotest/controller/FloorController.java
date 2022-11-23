package com.example.demobullsht.demotest.controller;

import java.util.*;

import com.example.demobullsht.demotest.dto.*;
import com.example.demobullsht.demotest.exception.*;
import com.example.demobullsht.demotest.mapper.*;
import com.example.demobullsht.demotest.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/floor")
public class FloorController {

    private final FloorService floorService;

    private final FloorMapper floorMapper;

    @PostMapping("/")
    public ResponseEntity<String> createFloor(Integer newFloorNumber, String newMapFloor) {
        floorService.addFloor(newFloorNumber, newMapFloor);

        return ResponseEntity.ok("Этаж успешно создан.");
    }

    @GetMapping("/all")
    public ResponseEntity<List<FloorDto>> getFloors() {
        List<FloorDto> floors;

        floors = floorService.getAll()
            .stream()
            .map(floorMapper::floorToDto)
            .toList();

        return ResponseEntity.ok(floors);
    }

    @GetMapping("/id{id}")
    public ResponseEntity<FloorDto> getFloorById(@PathVariable Long id) {
        return ResponseEntity.ok(floorMapper.floorToDto(floorService.getById(id))
        );
    }

    @GetMapping("/{floorNumber}")
    public ResponseEntity<FloorDto> getByFloorNumber(@PathVariable Integer floorNumber) {
        return ResponseEntity.ok(floorMapper.floorToDto(floorService.getByFloorNumber(floorNumber)));
    }

    @PutMapping("/")
    public ResponseEntity<String> updateFloor(FloorDto dtoWithNewFloorNumber) {
        if (dtoWithNewFloorNumber.getId() > 0) {
            throw new IllegalArgumentException("Этаж не найден");
        }
        Integer floorNumber = dtoWithNewFloorNumber.getFloorNumber().toUpperCase();
        if (!floorNumber.matches("^ROLE_\\w+$")) {
            throw new IllegalArgumentException(
                "Неверный формат роли! Должно быть: \"ROLE_YOUR_NAME\" или \"role_your_name\"");
        }
        dtoWithNewFloorNumber.setFloorNumber(floorNumber);
        floorService.updateFloor(floorMapper.dtoToFloor(dtoWithNewFloorNumber));

        return ResponseEntity.ok("Номер этажа изменен: " + floorNumber);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFloor(@PathVariable Long id) {
        floorService.deleteFloor(id);

        return ResponseEntity.ok("Этаж удален.");
    }

}
