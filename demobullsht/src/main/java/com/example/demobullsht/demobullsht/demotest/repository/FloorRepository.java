package com.example.demobullsht.demobullsht.demotest.repository;

import com.example.demobullsht.demobullsht.demotest.entity.FloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<FloorRepository, Long> {
    FloorEntity findByMapFloor(String mapFloor);
    FloorEntity findByFloorNumber(Integer floorNumber);
}