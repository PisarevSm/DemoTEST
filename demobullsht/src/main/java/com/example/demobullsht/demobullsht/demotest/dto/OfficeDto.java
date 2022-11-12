package com.example.demobullsht.demobullsht.demotest.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class OfficeDto {

    private Long id;

    private String address;

    private String workNumber;

    //private Time startOfDay;

    //private Time endOfDay;

    private List<Integer> floorList = new ArrayList <Integer>();


}
