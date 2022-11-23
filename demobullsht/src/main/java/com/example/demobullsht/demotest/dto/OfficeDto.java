package com.example.demobullsht.demotest.dto;

import java.time.*;

import com.example.demobullsht.demotest.entity.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfficeDto {

    private  Long id;

    private CityEntity city;

    private String address;

    private String workNumber;




    private LocalTime startOfDay;

    private LocalTime endOfDay;

    private Integer bookingRange;

}
