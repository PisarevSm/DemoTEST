package com.example.demobullsht.demobullsht.booking.repository;

import com.example.demobullsht.demobullsht.booking.entity.WorkPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkPlaceRepository extends JpaRepository<WorkPlaceEntity, Long> {

    WorkPlaceEntity findByCapacity(String Capacity);
}