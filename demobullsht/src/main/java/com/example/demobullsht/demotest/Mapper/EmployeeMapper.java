package com.example.demobullsht.demotest.Mapper;

import com.example.demobullsht.demotest.DTO.*;
import com.example.demobullsht.demotest.Entity.*;

public class EmployeeMapper {

    public static EmployeeDTO getEntityToDTO(EmployeeEntity employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getLogin(),
                employee.getEmail()
        );
    }

    public static EmployeeEntity getDTOToEntity(EmployeeDTO employeeDTO) {
        return new EmployeeEntity(
                employeeDTO.getName(),
                employeeDTO.getLogin(),
                null,
                employeeDTO.getEmail()
        );
    }

    public static EmployeeEntity getCreateDTOToEntity(EmployeeCreateDTO employeeCreateDTO){
        return new EmployeeEntity(
                employeeCreateDTO.getName(),
                employeeCreateDTO.getLogin(),
                employeeCreateDTO.getPassword(),
                employeeCreateDTO.getEmail()
        );
    }

}
