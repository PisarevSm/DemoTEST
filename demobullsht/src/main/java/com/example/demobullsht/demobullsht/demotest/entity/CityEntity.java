package com.example.demobullsht.demobullsht.demotest.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Builder
@Entity(name = "city")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String cityName;

    public CityEntity
            (String cityName) {
        this.cityName = cityName;
    }

}