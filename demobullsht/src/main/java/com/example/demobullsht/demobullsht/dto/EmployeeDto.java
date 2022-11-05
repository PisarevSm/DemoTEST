package com.example.demobullsht.demobullsht.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private Long id;
    private String name;
    private String login;
    private String mail;

    public EmployeeDto(Long id, String name, String login, String mail) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.mail = mail;
    }
}
