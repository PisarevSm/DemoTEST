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
@RequestMapping("/role")
public class WorkPlaceTypeController {
    private final WorkPlaceTypeService workPlaceTypeService;

    private final WorkPlaceTypeMapper workPlaceTypeMapper;

    @PostMapping("/")
    public ResponseEntity<String> createWorkPlaceType(String newTypeName) {
        workPlaceTypeService.add(newTypeName);

        return ResponseEntity.ok("Тип места успешно создан.");
    }

    @GetMapping("/all")
    public ResponseEntity<List<WorkPlaceTypeDto>> getTypes() {
        List<WorkPlaceTypeDto> types = new ArrayList<>();

        types = workPlaceTypeService.getAll()
            .stream()
            .map(workPlaceTypeMapper::typeToDto)
            .toList();

        return ResponseEntity.ok(types);
    }

    @GetMapping("/id{id}")
    public ResponseEntity<WorkPlaceTypeDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
            workPlaceTypeMapper.typeToDto(
                workPlaceTypeService.getById(id))
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<WorkPlaceTypeDto> getWorkPlaceTypeByName(@PathVariable String name) {
        return ResponseEntity.ok(
            workPlaceTypeMapper.typeToDto(
                workPlaceTypeService.getByName(name))
        );
    }

    @PutMapping("/")
    public ResponseEntity<String> updateWorkPlaceType(WorkPlaceTypeDto dtoWithNewName) {
        if (workPlaceTypeService.getById(dtoWithNewName.getId()) == null) {
            throw new NotFoundException("Тип места не найден.");
        }

        workPlaceTypeService.updateWorkPlaceType(dtoWithNewName.getName());

        return ResponseEntity.ok("Название типа места измененно на: " + dtoWithNewName.getName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkPlaceType(@PathVariable Long id) {
        workPlaceTypeService.deleteWorkPlaceType(id);

        return ResponseEntity.ok("Тип места удалён.");
    }

}
