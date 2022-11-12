package com.example.demobullsht.demobullsht.demotest.mapper;


import com.example.demobullsht.demobullsht.demotest.dto.WorkPlaceTypeDto;
import com.example.demobullsht.demobullsht.demotest.entity.WorkPlaceTypeEntity;

public class WorkPlaceTypeMapper {
    public static WorkPlaceTypeDto mapWorkPlaceTypeEntityToDto(
            WorkPlaceTypeEntity workPlaceTypeEntity) {
        return new WorkPlaceTypeDto(
                WorkPlaceTypeEntity.getId(),
                WorkPlaceTypeEntity.getTypeName()
        );
    }
}
