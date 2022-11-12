package com.example.demobullsht.demobullsht.demotest.mapper;

import com.example.demobullsht.demobullsht.demotest.dto.OfficeDto;
import com.example.demobullsht.demobullsht.demotest.entity.OfficeEntity;

import java.util.ArrayList;
import java.util.List;

public class OfficeMapper {
    public static OfficeDto mapOfficeEntityToDto(OfficeEntity officeEntity) {
        return new OfficeDto(
                OfficeEntity.getId(),
                OfficeEntity.getAddress(),
                OfficeEntity.getWorkNumber()
//                time?
//                OfficeEntity.getFloorList()
        );
    }
}


