package com.example.demobullsht.demotest.Entity.Repository;

import com.example.demobullsht.demotest.Entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface WorkPlaceRepository extends JpaRepository<WorkPlaceEntity, Long> {

}
