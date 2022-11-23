package com.example.demobullsht.demotest.repository;

import com.example.demobullsht.demotest.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface OfficeRepository extends JpaRepository<OfficeEntity, Long> {

    OfficeEntity findByAddress(String address);

    OfficeEntity findByWorkNumber(String workNumber);

    boolean existsByAddress(String address);

}
