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
            .orElseThrow(() -> new NotFoundException(String.format(
                "Места с таким id не существует: %s",
                id)));

    }

    public void update(WorkPlaceEntity workPlace) {
        WorkPlaceEntity workPlaceUpdate = getById(workPlace.getId());

        if (workPlaceUpdate == null) {
            throw new NotFoundException("Место не найдено "+ workPlace.getId());
        }

        if (workPlace.getFloor() == null){
            workPlaceUpdate.setFloor(workPlace.getFloor());
        }

        if (workPlace.getType() == null){
            workPlaceUpdate.setType(workPlace.getType());
        }

        if (workPlace.getCapacity() >= 1){
            workPlaceUpdate.setCapacity(workPlace.getCapacity());
        }

        workPlaceRepository.save(workPlaceUpdate);
    }

    public void deleteWorkPlace(Long id) {

        if (getById(id) == null) {
            throw new NotFoundException(String.format("Места с таким id не существует: %s", id));
        }
        workPlaceRepository.deleteById(id);
    }

}
