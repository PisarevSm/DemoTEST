package com.example.demobullsht.demotest.mapper;

import com.example.demobullsht.demotest.dto.*;
import com.example.demobullsht.demotest.entity.*;
import lombok.*;
import org.springframework.stereotype.*;

@Component
@RequiredArgsConstructor
public class WorkPlaceMapper {

    public WorkPlaceDto workPlaceToDto(WorkPlaceEntity workPlace) {
        WorkPlaceDto dto = new WorkPlaceDto(
            workPlace.getId(),
            workPlace.getCapacity()
        );

        return dto;
    }

}
