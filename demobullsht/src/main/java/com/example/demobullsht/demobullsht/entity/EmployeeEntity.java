package com.example.demobullsht.demobullsht.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
public class EmployeeEntity {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String name;
    private String login;
    private String password;
    private String mail;


    public EmployeeEntity() {

    }

    public EmployeeEntity(String name, String login, String password, String mail) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.mail = mail;
    }
}
