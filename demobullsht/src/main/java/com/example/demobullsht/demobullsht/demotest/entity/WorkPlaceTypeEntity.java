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

public class WorkPlaceTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String typeName;

}