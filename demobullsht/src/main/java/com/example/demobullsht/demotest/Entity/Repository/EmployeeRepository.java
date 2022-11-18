package com.example.demobullsht.demotest.Entity.Repository;

import java.util.*;

import com.example.demobullsht.demotest.Entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByLogin(String login);

}
