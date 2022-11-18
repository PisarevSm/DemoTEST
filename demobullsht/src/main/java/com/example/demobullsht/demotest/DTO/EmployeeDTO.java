package com.example.demobullsht.demotest.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    private String name, login, email;

}
