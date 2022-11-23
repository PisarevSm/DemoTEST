package com.example.demobullsht.demotest.repository;

import com.example.demobullsht.demotest.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface FloorRepository extends JpaRepository<FloorEntity, Long> {

    FloorEntity findByFloorNumber(Integer floorNumber);

    boolean existsByFloorNumber(Integer floorNumber);

}
