package com.example.demobullsht.demobullsht.demotest.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Builder
@Entity(name = "office")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class OfficeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String address;
    private String workNumber;
    //private Time startOfDay;
    //private Time endOfDay;
    //private Integer bookingRange;
    public OfficeEntity(
            String address,
            String workNumber
            //Time startOfDay,
            //Time endOfDay,
            //Integer bookingRange;
    ) {
        this.address = address;
        this.workNumber = workNumber;
//        this.startOfDay = startOfDay;
//        this.endOfDay = endOfDay;
//        this.bookingRange = bookingRange;
    }

}