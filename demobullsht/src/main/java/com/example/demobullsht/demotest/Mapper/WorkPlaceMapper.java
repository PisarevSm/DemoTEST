package com.example.demobullsht.demotest.Mapper;

import com.example.demobullsht.demotest.DTO.*;
import com.example.demobullsht.demotest.Entity.*;


public class WorkPlaceMapper {

    public static WorkPlaceDTO mapWorkPlaceEntityToDto(WorkPlaceEntity workPlaceEntity) {
        return new WorkPlaceDTO(
            workPlaceEntity.getId(),
            workPlaceEntity.getCapacity()
        );
    }

    public static WorkPlaceEntity getDTOToEntity(WorkPlaceDTO workPlaceDTO) {
        return new WorkPlaceEntity(
                workPlaceDTO.getId(),
                workPlaceDTO.getCapacity()
        );
    }
}
