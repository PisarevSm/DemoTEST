package com.example.demobullsht.demotest.Entity;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Table
@Data
public class WorkPlaceEntity {

    @Id
    @SequenceGenerator(
            name = "work_place_sequence",
            sequenceName = "work_place_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "work_place_sequence"
    )
    private Long id;
    private String capacity;

//    @OneToMany(mappedBy = "workPlace", cascade = CascadeType.ALL)
//    private List<BookingEntity> bookingList = new ArrayList<>();

    /*public void addBooking(BookingEntity bookingEntity){
        bookingList.add(bookingEntity);
        bookingEntity.setWorkPlace(this);
    }
    public void removeBooking(BookingEntity bookingEntity){
        bookingList.remove(bookingEntity);
        bookingEntity.setWorkPlace(null);
    }*/

    public WorkPlaceEntity(Long id, String capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public WorkPlaceEntity(String capacity) {
        this.capacity = capacity;
    }

    public WorkPlaceEntity() {}

}
