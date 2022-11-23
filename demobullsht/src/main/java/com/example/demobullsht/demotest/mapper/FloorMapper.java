package com.example.demobullsht.demotest.mapper;

import com.example.demobullsht.demotest.dto.*;
import com.example.demobullsht.demotest.entity.*;
import lombok.*;
import org.springframework.stereotype.*;


@Component
@RequiredArgsConstructor
public class FloorMapper {

    public FloorDto floorToDto(FloorEntity floor) {

        return new FloorDto(
            floor.getId(),
            floor.getFloorNumber(),
            floor.getMapFloor()
        );
    }
    public FloorEntity dtoToFloor(FloorDto floorDto) {

        return new FloorEntity(
            floorDto.getId(),
            floorDto.getFloorNumber(),
            floorDto.getMapFloor()
        );
    }

}

