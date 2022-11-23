package com.example.demobullsht.demotest.controller;

import java.util.*;

import com.example.demobullsht.demotest.dto.*;
import com.example.demobullsht.demotest.entity.*;
import com.example.demobullsht.demotest.mapper.*;
import com.example.demobullsht.demotest.service.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workplace")
public class WorkPlaceController {

    private final WorkPlaceService workPlaceService;

    private final WorkPlaceMapper workPlaceMapper;

    private final FloorService floorService;

    private final WorkPlaceTypeService workPlaceTypeService;


    @PostMapping("/")
    public ResponseEntity<String> createWorkPlace(String newWorkPlace) {
        workPlaceService.addWorkPlace(newWorkPlace);

        return ResponseEntity.ok("Город успешно создан.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkPlaceDto> getWorkPlaceById(@PathVariable Long id) {
        return ResponseEntity.ok(workPlaceMapper.workPlaceToDto(workPlaceService.getById(id))
        );
    }

    @GetMapping("/all")
    public ResponseEntity<Page<WorkPlaceDto>> getWorkPlace(PageRequest pageRequest) {
        Page<WorkPlaceEntity> workPlace = workPlaceService.getAll(pageRequest);
        Page<WorkPlaceDto> workPlaceDto = workPlace.map(workPlaceMapper::workPlaceToDto);
        return ResponseEntity.ok(workPlaceDto);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateWorkPlace(@RequestBody WorkPlaceDto dto) {
        FloorEntity floor;
        floor = floorService.getById(dto.getFloorId());
        WorkPlaceTypeEntity type;
        type = workPlaceTypeService.getById(dto.getTypeId());
        workPlaceService.update(workPlaceMapper.dtoToWorkPlace(dto, floor, type));

        return ResponseEntity.ok("Данные этажа успешно измененны.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkPlace(@PathVariable Long id) {
        workPlaceService.deleteWorkPlace(id);

        return ResponseEntity.ok("Место удаленно.");
    }

}
