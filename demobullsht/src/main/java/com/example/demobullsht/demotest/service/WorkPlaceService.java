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
public class WorkPlaceService {

    private final WorkPlaceRepository workPlaceRepository;

    public void addWorkPlace(WorkPlaceTypeEntity type, FloorEntity floor, Integer capacity) {
        workPlaceRepository.save(new WorkPlaceEntity(null, type, floor, capacity));
    }

    public Page<WorkPlaceEntity> getAll(PageRequest pageRequest) {
        return workPlaceRepository.findAll(pageRequest);
    }

    public WorkPlaceEntity getById(Long id) {
        return workPlaceRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundException(String.format("Места с таким id не существует: %s", id)));

    }
    public void updateWorkPlace(WorkPlaceEntity workPlaceEntity) {
        workPlaceRepository.save(workPlaceEntity);
    }

    public void deleteWorkPlace(Long id) {

        if (getById(id) == null) {
            throw new NotFoundException(String.format("Места с таким id не существует: %s", id));
        }

        workPlaceRepository.deleteById(id);
    }

}
