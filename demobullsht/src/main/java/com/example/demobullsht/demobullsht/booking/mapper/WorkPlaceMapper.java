package com.example.demobullsht.demobullsht.booking.mapper;
import com.example.demobullsht.demobullsht.booking.dto.WorkPlaceDto;
import com.example.demobullsht.demobullsht.booking.entity.WorkPlaceEntity;


public class WorkPlaceMapper {
    public static WorkPlaceDto mapWorkPlaceEntityToDto(WorkPlaceEntity workPlaceEntity) {
        return new WorkPlaceDto(
                workPlaceEntity.getId(),
                workPlaceEntity.getCapacity()
        );
    }

}

