package com.example.demobullsht.demobullsht.service;

import com.example.demobullsht.demobullsht.entity.EmployeeEntity;
import com.example.demobullsht.demobullsht.entity.WorkPlaceEntity;
import com.example.demobullsht.demobullsht.repository.EmployeeRepository;
import com.example.demobullsht.demobullsht.repository.WorkPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkPlaceService {
    private final WorkPlaceRepository workPlaceRepository;

    /*public WorkPlaceService(WorkPlaceRepository workPlaceRepository) {
        this.workPlaceRepository = workPlaceRepository;
    }*/


    public List<WorkPlaceEntity> getWorkPlace() {
        return workPlaceRepository.findAll();
    }

    public Optional<WorkPlaceEntity> getWorkPlaceById(Long id) {
        return workPlaceRepository.findById(id);
    }

    public Optional<WorkPlaceEntity> getWorkPlaceByNumberSeat(String numberSeat) {
        return workPlaceRepository.findWorkPlaceEntityByNumberSeat(numberSeat);
    }

    public void addNewWorkPlaceEntity(WorkPlaceEntity workPlaceEntity) {
        workPlaceRepository.save(workPlaceEntity);
    }


    @Transactional
    public void updateWorkPlaceEntity(Long id, String numberSeat) {
        WorkPlaceEntity workPlaceEntity = workPlaceRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "employee with id " + id + "doesn't exist"));
        if (numberSeat != null &&
                numberSeat.length() > 0 &&
                !Objects.equals(workPlaceEntity.getNumberSeat(), numberSeat)) {
            workPlaceEntity.setNumberSeat(numberSeat);
        }
    }

    public void deleteWorkPlaceEntity(Long id) {
        boolean exists = workPlaceRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "employee with id " + id + "doesn't exist");
        }
        workPlaceRepository.deleteById(id);
    }
}
