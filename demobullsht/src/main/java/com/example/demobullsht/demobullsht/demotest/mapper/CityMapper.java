package com.example.demobullsht.demobullsht.demotest.mapper;

import com.example.demobullsht.demobullsht.demotest.dto.CityDto;
import com.example.demobullsht.demobullsht.demotest.entity.CityEntity;

public class CityMapper {
    public static CityDto mapCityEntityToDto(CityEntity cityEntity) {
        return new CityDto(
                CityEntity.getId(),
                CityEntity.getCityName()
        );
    }
}
