package com.example.demobullsht.demotest.Entity;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Table
@Data
public class EmployeeEntity {

    @Id
    @SequenceGenerator(
            name = "employee_id_seq",
            sequenceName = "employee_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_id_seq"
    )

    private Long id;
    private String name, login, password, email;

//    @OneToMany(mappedBy = "employee")
//    private List<BookingEntity> bookingList = new ArrayList<>();

    /*public void addBooking(BookingEntity bookingEntity){
        bookingList.add(bookingEntity);
        bookingEntity.setEmployee(this);
    }
    public void removeBooking(BookingEntity bookingEntity){
        bookingList.remove(bookingEntity);
        bookingEntity.setEmployee(null);
    }*/

    public EmployeeEntity(String name, String login, String password, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public EmployeeEntity() {

    }

}
