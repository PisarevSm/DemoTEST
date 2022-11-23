package com.example.demobullsht.demotest.mapper;

import com.example.demobullsht.demotest.dto.*;
import com.example.demobullsht.demotest.entity.*;
import lombok.*;
import org.springframework.stereotype.*;


@Component
@RequiredArgsConstructor
public class WorkPlaceTypeMapper {

    public WorkPlaceTypeDto typeToDto(WorkPlaceTypeEntity type) {
        return new WorkPlaceTypeDto(
            type.getId(),
            type.getType().getId(),
            workPlace.getFloor().getId(),
            workPlace.getCapacity()
        );
    }

}
