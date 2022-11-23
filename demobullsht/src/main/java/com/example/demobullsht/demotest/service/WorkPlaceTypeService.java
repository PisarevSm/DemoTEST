package com.example.demobullsht.demotest.service;


import java.util.*;

import com.example.demobullsht.demotest.entity.*;
import com.example.demobullsht.demotest.exception.*;
import com.example.demobullsht.demotest.repository.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;


@Service
@RequiredArgsConstructor
public class WorkPlaceTypeService {

    private final WorkPlaceTypeRepository workPlaceTypeRepository;

    public void add(String name) {
        boolean exists = workPlaceTypeRepository.existsByName(name);

        if (exists) {
            throw new AlreadyExistsException("Такой тип места уже существует!");
        }

        workPlaceTypeRepository.save(new WorkPlaceTypeEntity(null, name));
    }

    public List<WorkPlaceTypeEntity> getAll() {
        return workPlaceTypeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public WorkPlaceTypeEntity getById(Long id) {
        return workPlaceTypeRepository.findById(id).orElse(null);
    }

    public WorkPlaceTypeEntity getByName(String name) {
        return workPlaceTypeRepository.findByName(name);
    }

    public void updateWorkPlaceType(String newName) {
        workPlaceTypeRepository.save(new WorkPlaceTypeEntity(null, newName));
    }

    public void deleteWorkPlaceType(Long id) {

        if (getById(id) == null) {
            throw new NotFoundException("Тип места не найден");
        }

        workPlaceTypeRepository.deleteById(id);
    }

}
