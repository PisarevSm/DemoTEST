package com.example.demobullsht.demotest.mapper;

import java.time.*;

import com.example.demobullsht.demotest.dto.*;
import com.example.demobullsht.demotest.entity.*;
import lombok.*;
import org.springframework.stereotype.*;


@Component
@RequiredArgsConstructor
public class OfficeMapper {

    public OfficeDto officeToDto(OfficeEntity office) {
        OfficeDto dto = new OfficeDto(
            office.getId(),
            office.getCity(),
            office.getAddress(),
            office.getWorkNumber(),
            office.getStartOfDay(),
            office.getEndOfDay(),
            office.getBookingRange()
        );

        return dto;
    }

}