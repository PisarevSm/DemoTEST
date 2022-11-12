package com.example.demobullsht.demobullsht.demotest.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Builder
@Entity(name = "floor")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class FloorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    private Integer floorNumber;
    private String mapFloor;

    public FloorEntity(
            Integer floorNumber,
            String mapFloor
    ) {
        this.floorNumber = floorNumber;
        this.mapFloor = mapFloor;
    }

}