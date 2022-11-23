package com.example.demobullsht.demotest.service;


import java.util.*;

import com.example.demobullsht.demotest.entity.*;
import com.example.demobullsht.demotest.exception.*;
import com.example.demobullsht.demotest.repository.*;
import lombok.*;
import org.springframework.stereotype.*;


@Service
@RequiredArgsConstructor
public class FloorService {

    private final FloorRepository floorRepository;

    public void addFloor(Integer floorNumber, String mapFloor) {
        boolean exists = floorRepository.existsByFloorNumber(floorNumber);

        if (exists) {
            throw new AlreadyExistsException("Данный этаж уже существует!");
        }

        floorRepository.save(new FloorEntity(null, floorNumber, mapFloor));
    }

    public List<FloorEntity> getAll() {
        return floorRepository.findAll();
    }

    public FloorEntity getById(Long id) {
        return floorRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundException(String.format("Этажа с данным id не существует: %s", id)));
    }

    public FloorEntity getByFloorNumber(Integer floorNumber) {
        return floorRepository.findByFloorNumber(floorNumber);
    }

    public void updateFloor(FloorEntity floor) {
        FloorEntity updateFloor = getById(floor.getId());

        if (updateFloor == null) {
            throw new NotFoundException("Этаж не найден.");
        }

        if (floor.getFloorNumber() != null) {
            updateFloor.setFloorNumber(floor.getFloorNumber());
        }

        if (floor.getMapFloor() != null) {
            updateFloor.setMapFloor(floor.getMapFloor());
        }
        floorRepository.save(updateFloor);
    }

    public void deleteFloor(Long id) {

        if (getById(id) == null) {
            throw new NotFoundException(String.format("Этажа с данным id не существует: %s", id));
        }


        floorRepository.deleteById(id);
    }

}
