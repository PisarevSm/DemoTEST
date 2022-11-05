package com.example.demobullsht.demobullsht.mapper;

import com.example.demobullsht.demobullsht.dto.EmployeeCreateDto;
import com.example.demobullsht.demobullsht.dto.EmployeeDto;
import com.example.demobullsht.demobullsht.entity.EmployeeEntity;

public class EmployeeMapper {
    public static EmployeeDto mapEmployeeEntityToDto(EmployeeEntity employeeEntity) {
        return new EmployeeDto(
                employeeEntity.getId(),
                employeeEntity.getName(),
                employeeEntity.getLogin(),
                employeeEntity.getMail()
        );
    }

    public static EmployeeEntity mapEmployeeCreateDtoToEntity(EmployeeCreateDto employeeCreateDto) {
        return new EmployeeEntity(
                employeeCreateDto.getName(),
                employeeCreateDto.getLogin(),
                employeeCreateDto.getPassword(),
                employeeCreateDto.getMail()
        );
    }
}
