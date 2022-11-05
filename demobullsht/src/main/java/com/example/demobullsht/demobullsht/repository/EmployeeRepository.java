package com.example.demobullsht.demobullsht.repository;

import com.example.demobullsht.demobullsht.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

            //@Query("SELECT s FROM EmployeeEntity s WHERE s.mail=?1")
        EmployeeEntity findEmployeeEntityByLogin(String login);
}
