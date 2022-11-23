package com.example.demobullsht.demotest.repository;

import com.example.demobullsht.demotest.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface WorkPlaceRepository extends JpaRepository<WorkPlaceEntity, Long> {

    WorkPlaceEntity findByCapacity(Integer capacity);

}
