package com.example.demobullsht.demobullsht.repository;

import com.example.demobullsht.demobullsht.entity.WorkPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkPlaceRepository extends JpaRepository<WorkPlaceEntity, Long> {

    Optional<WorkPlaceEntity> findWorkPlaceEntityByNumberSeat(String numberSeat);
}