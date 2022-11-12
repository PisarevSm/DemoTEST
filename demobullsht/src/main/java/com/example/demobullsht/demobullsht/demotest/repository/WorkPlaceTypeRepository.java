package com.example.demobullsht.demobullsht.demotest.repository;

import com.example.demobullsht.demobullsht.demotest.entity.WorkPlaceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkPlaceTypeRepository extends JpaRepository<WorkPlaceTypeRepository, Long> {
    WorkPlaceTypeEntity findByTypeName(String typeName);
}