package com.example.demobullsht.demotest.Entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookings")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer guests;

    private LocalDateTime startBooking, endBooking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_place_id")
    @ToString.Exclude
    private WorkPlaceEntity workPlace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @ToString.Exclude
    private EmployeeEntity employee;

    public BookingEntity(
        Integer guests,
        LocalDateTime startBooking,
        LocalDateTime endBooking,
        WorkPlaceEntity workPlace,
        EmployeeEntity employee
    ) {
        this.guests = guests;
        this.startBooking = startBooking;
        this.endBooking = endBooking;
        this.workPlace = workPlace;
        this.employee = employee;
    }

}
