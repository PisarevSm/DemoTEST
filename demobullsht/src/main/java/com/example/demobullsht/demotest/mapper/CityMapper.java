package com.example.demobullsht.demotest.mapper;

import com.example.demobullsht.demotest.dto.*;
import com.example.demobullsht.demotest.entity.*;
import lombok.*;
import org.springframework.stereotype.*;


@Component
@RequiredArgsConstructor
public class CityMapper {

    public CityDto cityToDto(CityEntity city) {
        CityDto dto = new CityDto(
            city.getId(),
            city.getName()
        );

        return dto;
    }

}
