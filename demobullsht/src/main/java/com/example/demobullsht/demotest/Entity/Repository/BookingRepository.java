package com.example.demobullsht.demotest.Entity.Repository;

import com.example.demobullsht.demotest.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

}
