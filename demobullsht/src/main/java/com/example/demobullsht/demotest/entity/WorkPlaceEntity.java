package com.example.demobullsht.demotest.entity;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "workplaces")
@NoArgsConstructor(/*access = AccessLevel.PROTECTED*/)
public class WorkPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workplacetype_id")
    @ToString.Exclude
    private WorkPlaceTypeEntity type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id")
    @ToString.Exclude
    private FloorEntity floor;

    private Integer capacity;


}
