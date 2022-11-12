package com.example.demobullsht.demobullsht.booking.service;
import com.example.demobullsht.demobullsht.booking.entity.WorkPlaceEntity;
import com.example.demobullsht.demobullsht.booking.exception.WorkPlaceNotFoundException;
import com.example.demobullsht.demobullsht.booking.repository.WorkPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class WorkPlaceService {
    private final WorkPlaceRepository workPlaceRepository;


    public List<WorkPlaceEntity> getWorkPlace() {
        return workPlaceRepository.findAll();
    }

    public WorkPlaceEntity getWorkPlaceById(Long id) {
        return workPlaceRepository.findById(id)
                .orElseThrow( () -> new WorkPlaceNotFoundException("Место не найдено!"));
    }

    public WorkPlaceEntity getWorkPlaceByCapacity(String Capacity) {
        WorkPlaceEntity workPlaceEntityByCapacity = workPlaceRepository.findByCapacity(Capacity);
        if (workPlaceEntityByCapacity == null) {
            throw new RuntimeException("Место с таким количеством мест не найдено");
        } else {
            return workPlaceEntityByCapacity;
        }
    }

    public void addNewWorkPlaceEntity(WorkPlaceEntity workPlaceEntity) {
        workPlaceRepository.save(workPlaceEntity);
    }


    @Transactional
    public void updateWorkPlaceEntity(Long id, String Capacity) {
        WorkPlaceEntity workPlaceEntity = workPlaceRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "employee with id " + id + "doesn't exist"));
        if (Capacity != null &&
                Capacity.length() > 0 &&
                !Objects.equals(workPlaceEntity.getCapacity(), Capacity)) {
            workPlaceEntity.setCapacity(Capacity);
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
