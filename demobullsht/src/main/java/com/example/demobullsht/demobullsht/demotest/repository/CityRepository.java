package com.example.demobullsht.demobullsht.demotest.repository;

import com.example.demobullsht.demobullsht.demotest.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CityRepository extends JpaRepository<CityRepository, Long> {
    CityEntity findByCityName(String cityName);
}
