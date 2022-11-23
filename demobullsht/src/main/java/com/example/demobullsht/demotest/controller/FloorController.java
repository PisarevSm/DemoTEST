package com.example.demobullsht.demotest.controller;

import java.util.*;

import com.example.demobullsht.demotest.dto.*;
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
    public ResponseEntity<String> createFloor(FloorDto floorDto) {
        floorService.addFloor(floorMapper.floorToDto(floorDto));

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
    public ResponseEntity<String> updateFloor(FloorDto dtoNewFloor) {

        floorService.updateFloor(floorMapper.dtoToFloor(dtoNewFloor));

        return ResponseEntity.ok("Данные этажа измененны: "
                                 + dtoNewFloor.getMapFloor() + "; " + dtoNewFloor.getFloorNumber());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFloor(@PathVariable Long id) {
        floorService.deleteFloor(id);

        return ResponseEntity.ok("Этаж удален.");
    }

}
