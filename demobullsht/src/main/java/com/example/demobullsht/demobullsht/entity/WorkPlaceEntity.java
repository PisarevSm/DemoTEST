package com.example.demobullsht.demobullsht.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Entity
@Table
@Setter
@Getter
@ToString
public class WorkPlaceEntity {

    @Id
    @SequenceGenerator(
            name = "workplace_sequence",
            sequenceName = "workplace_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "workplace_sequence"
    )
    private Long id;

    private String numberSeat;

    public WorkPlaceEntity() {}
}