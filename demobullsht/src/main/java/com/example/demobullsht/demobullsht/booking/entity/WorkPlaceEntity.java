package com.example.demobullsht.demobullsht.booking.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Builder
@Entity(name = "`workplace`")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
public class WorkPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String capacity;

}