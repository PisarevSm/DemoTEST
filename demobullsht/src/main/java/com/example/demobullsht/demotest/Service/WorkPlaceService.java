package com.example.demobullsht.demotest.Service;

import java.util.*;

import com.example.demobullsht.demotest.Entity.*;
import com.example.demobullsht.demotest.Entity.Repository.*;
import com.example.demobullsht.demotest.Exception.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@RequiredArgsConstructor
public class WorkPlaceService {
    private final WorkPlaceRepository workPlaceRepository;


    public List<WorkPlaceEntity> getWorkPlace() {
        return workPlaceRepository.findAll();
    }

    public WorkPlaceEntity getWorkPlaceById(Long id) {
        return workPlaceRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Рабочее место не найдено!"));
    }

    public void addNewWorkPlaceEntity(WorkPlaceEntity workPlaceEntity) {
        workPlaceRepository.save(workPlaceEntity);
    }


    @Transactional
    public void updateWorkPlaceEntity(Long id, String Capacity) {
        WorkPlaceEntity workPlaceEntity = workPlaceRepository.findById(id).orElseThrow(() -> new IllegalStateException(
            "Рабочего места с id: " + id + "не найдено"));
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
                "Рабочего места с id: " + id + "не найдено");
        }
        workPlaceRepository.deleteById(id);
    }
}
