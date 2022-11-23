package com.example.demobullsht.demotest.mapper;

import com.example.demobullsht.demotest.dto.*;
import com.example.demobullsht.demotest.entity.*;
import lombok.*;
import org.springframework.stereotype.*;

@Component
@RequiredArgsConstructor
public class WorkPlaceMapper {

    public WorkPlaceDto workPlaceToDto(WorkPlaceEntity workPlace) {

        return new WorkPlaceDto(
            workPlace.getId(),
            workPlace.getType().getId(),
            workPlace.getFloor().getId(),
            workPlace.getCapacity()
        );
    }
    public WorkPlaceEntity dtoToWorkPlace(WorkPlaceDto dto, FloorEntity floor, WorkPlaceTypeEntity type) {

        return new WorkPlaceEntity(
            dto.getId(),
            type,
            floor,
            dto.getCapacity()
        );
    }

}
