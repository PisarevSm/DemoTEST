package com.example.demobullsht.demotest.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class FloorDto {

    private Long id;

    private Integer floorNumber;

    private String mapFloor;

}
