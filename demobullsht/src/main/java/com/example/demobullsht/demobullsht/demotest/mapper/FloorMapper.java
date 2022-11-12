package com.example.demobullsht.demobullsht.demotest.mapper;

import com.example.demobullsht.demobullsht.demotest.dto.FloorDto;
import com.example.demobullsht.demobullsht.demotest.entity.FloorEntity;

public class FloorMapper {
    public static FloorDto mapFloorEntityToDto(FloorEntity floorEntity) {
        return new FloorDto(
                FloorEntity.getId(),
                FloorEntity.getFloorNumber(),
                FloorEntity.getMapFloor()
//                FloorEntity.getCapacityList()
        );
    }
}

