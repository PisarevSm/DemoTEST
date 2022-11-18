package com.example.demobullsht.demotest.Controller;

import java.util.*;

import com.example.demobullsht.demotest.DTO.*;
import com.example.demobullsht.demotest.Entity.*;
import com.example.demobullsht.demotest.Mapper.*;
import com.example.demobullsht.demotest.Service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workplace")
public class WorkPlaceController {
    private final WorkPlaceService workPlaceService;


    @GetMapping("/")
    public List<WorkPlaceDTO> getWorkPlace() {
        List<WorkPlaceEntity> workPlaceEntity = workPlaceService.getWorkPlace();
        return workPlaceEntity.stream()
            .map(WorkPlaceMapper::mapWorkPlaceEntityToDto)
            .toList();
    }

    @GetMapping("/{id}")
    public WorkPlaceDTO getFindById(@PathVariable Long id) {
        return WorkPlaceMapper.mapWorkPlaceEntityToDto(workPlaceService.getWorkPlaceById(id));
    }

    @PostMapping
    public void addNewWorkPlace(@RequestBody WorkPlaceEntity workPlaceEntity) {
        workPlaceService.addNewWorkPlaceEntity(workPlaceEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkPlaceEntity(@PathVariable Long id) {
        workPlaceService.deleteWorkPlaceEntity(id);
    }

    @PutMapping("/{id}")
    public void updateWorkPlaceEntity(
        @PathVariable Long id,
        @RequestParam(required = false) String Capacity) {
        workPlaceService.updateWorkPlaceEntity(id, Capacity);
    }
}
