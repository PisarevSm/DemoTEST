package com.example.demobullsht.demobullsht.demotest.repository;

import com.example.demobullsht.demobullsht.demotest.entity.OfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<OfficeRepository, Long> {
    OfficeEntity findByAddress(String address);
    OfficeEntity findByWorkNumber(String workNumber);
}