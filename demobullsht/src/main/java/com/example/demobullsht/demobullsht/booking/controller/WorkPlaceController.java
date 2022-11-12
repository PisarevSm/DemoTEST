package com.example.demobullsht.demobullsht.booking.controller;

import com.example.demobullsht.demobullsht.booking.dto.WorkPlaceDto;
import com.example.demobullsht.demobullsht.booking.entity.WorkPlaceEntity;
import com.example.demobullsht.demobullsht.booking.mapper.WorkPlaceMapper;
import com.example.demobullsht.demobullsht.booking.service.WorkPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workplace")
public class WorkPlaceController {
    private final WorkPlaceService workPlaceService;



    @GetMapping("/")
    public List<WorkPlaceDto> getWorkPlace() {
        List<WorkPlaceEntity> workPlaceEntity = workPlaceService.getWorkPlace();
        return workPlaceEntity.stream()
                .map(WorkPlaceMapper::mapWorkPlaceEntityToDto)
                .toList();
    }
    @GetMapping("/{id}")
    public WorkPlaceDto getFindById(@PathVariable Long id) {
        return WorkPlaceMapper.mapWorkPlaceEntityToDto(workPlaceService.getWorkPlaceById(id));
    }
    @GetMapping("/get")
    public ResponseEntity<WorkPlaceDto> getFindByCapacity(@RequestParam(required = true) String Capacity) {
        return ResponseEntity.status(HttpStatus.OK).body(
                WorkPlaceMapper.mapWorkPlaceEntityToDto(workPlaceService.getWorkPlaceByCapacity(Capacity))
        );
    }

    @PostMapping
    public void addNewWorkPlace(@RequestBody WorkPlaceEntity workPlaceEntity) {
        workPlaceService.addNewWorkPlaceEntity(workPlaceEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkPlaceEntity(@PathVariable Long id){
        workPlaceService.deleteWorkPlaceEntity(id);;
    }

    @PutMapping("/{id}")
    public void updateWorkPlaceEntity(
            @PathVariable Long id,
            @RequestParam(required = false) String Capacity){
        workPlaceService.updateWorkPlaceEntity(id, Capacity);
    }
}