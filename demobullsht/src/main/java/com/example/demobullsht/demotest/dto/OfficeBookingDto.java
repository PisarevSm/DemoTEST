package com.example.demobullsht.demotest.dto;

import com.example.demobullsht.demotest.entity.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OfficeBookingDto {

    private Long id;

    private CityEntity city;

    private String address;

}