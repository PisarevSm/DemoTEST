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

public class FloorDto {

    private Long id;

    private Integer floorNumber;

    private String mapFloor;

    private List<Integer> capacityList = new ArrayList<Integer>();


}