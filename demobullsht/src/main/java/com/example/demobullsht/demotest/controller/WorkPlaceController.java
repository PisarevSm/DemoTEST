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

    @PostMapping("/")
    public ResponseEntity<String> createWorkPlace(WorkPlaceTypeEntity type, FloorEntity floor, Integer newCapacity) {
        workPlaceService.addWorkPlace(type,floor,newCapacity);

        return ResponseEntity.ok("Место успешно создано.");
    }
    //'это
    @GetMapping("/all")
    public ResponseEntity<Page<WorkPlaceDto>> getWorkPlace() {
        Page<WorkPlaceDto> workPlace;

        workPlace = workPlaceService.getAll()
            .stream()
            .map(workPlaceMapper::workPlaceToDto)
            .toPage();

        return ResponseEntity.ok(workPlace);
    }
//    public List<WorkPlaceEntity> getAll() {
//        return workPlaceRepository.findAll();
//    }
//public Page<WorkPlaceEntity> getAll(PageRequest pageRequest) {
//    return workPlaceRepository.findAll(pageRequest);
//}

    @GetMapping("/{id}")
    public ResponseEntity<WorkPlaceDto> getWorkPlaceById(@PathVariable Long id) {
        return ResponseEntity.ok(workPlaceMapper.workPlaceToDto(workPlaceService.getById(id))
        );
    }

    @PutMapping("/")
    public void updateWorkPlace(
        @PathVariable("workPlaceId") Long id,
        @RequestBody WorkPlaceDto workPlaceDto
    ) {

        WorkPlaceEntity workPlaceEntity = workPlaceService.getById(id);

        if (workPlaceDto.getCapacity() != null &&
            workPlaceDto.getCapacity().longValue() > 0 &&
            !Objects.equals(workPlaceEntity.getCapacity(), workPlaceDto.getCapacity())) {
            workPlaceEntity.setCapacity(workPlaceDto.getCapacity());
        }
        workPlaceService.updateWorkPlace(workPlaceEntity);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkPlace(@PathVariable Long id) {
        workPlaceService.deleteWorkPlace(id);

        return ResponseEntity.ok("Место удаленно.");
    }

}