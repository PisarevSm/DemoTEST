package com.example.demobullsht.demotest.repository;

import com.example.demobullsht.demotest.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    CityEntity findByName(String name);

    boolean existsByName(String name);

}
