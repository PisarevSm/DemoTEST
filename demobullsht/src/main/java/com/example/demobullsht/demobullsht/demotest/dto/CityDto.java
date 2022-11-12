package com.example.demobullsht.demobullsht.demotest.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class CityDto {

    private Long id;

    private String cityName;


}
