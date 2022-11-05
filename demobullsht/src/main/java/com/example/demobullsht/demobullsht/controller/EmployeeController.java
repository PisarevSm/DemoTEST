package com.example.demobullsht.demobullsht.controller;

import com.example.demobullsht.demobullsht.dto.EmployeeCreateDto;
import com.example.demobullsht.demobullsht.dto.EmployeeDto;
import com.example.demobullsht.demobullsht.entity.EmployeeEntity;
import com.example.demobullsht.demobullsht.mapper.EmployeeMapper;
import com.example.demobullsht.demobullsht.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    //    сюда отправлять определенный DTO
    @GetMapping
    public List<EmployeeDto> getEmployees() {
        List<EmployeeEntity> employeeEntity = employeeService.getEmployees();
        return employeeEntity.stream()
                .map(EmployeeMapper::mapEmployeeEntityToDto)
                .toList();
    }

    @GetMapping("/{id}")
    public EmployeeDto getFindById(@PathVariable Long id) {
        return EmployeeMapper.mapEmployeeEntityToDto(employeeService.getEmployeeById(id));
    }

    @GetMapping("/get")
    public ResponseEntity<EmployeeDto> getFindByLogin(@RequestParam(required = true) String login) {
        return ResponseEntity.status(HttpStatus.OK).body(
                EmployeeMapper.mapEmployeeEntityToDto(employeeService.getEmployeeByLogin(login))
        );
    }

    @PostMapping
    public void registerNewEmployee(@RequestBody EmployeeCreateDto employeeCreateDto) { //объект

        employeeService.addNewEmployeeEntity(EmployeeMapper.mapEmployeeCreateDtoToEntity(employeeCreateDto));
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeEntity(@PathVariable Long id) {
        employeeService.deleteEmployeeEntity(id);
    }

    // вписать объект целиком
    @PutMapping("/{id}")
    public void updateEmployeeEntity(
            @PathVariable Long id,
            @RequestBody EmployeeCreateDto employeeCreateDto) {

        EmployeeEntity employeeEntity = employeeService.getEmployeeById(id);

        if (employeeCreateDto.getName() != null &&
                employeeCreateDto.getName().length() > 0 &&
                !Objects.equals(employeeEntity.getName(), employeeCreateDto.getName())) {
            employeeEntity.setName(employeeCreateDto.getName());
        }

        if (employeeCreateDto.getMail() != null &&
                employeeCreateDto.getMail().length() > 0 &&
                !Objects.equals(employeeEntity.getMail(), employeeCreateDto.getMail())) {
            employeeEntity.setName(employeeCreateDto.getMail());
        }

        if (employeeCreateDto.getPassword() != null &&
                employeeCreateDto.getPassword().length() > 0 &&
                !Objects.equals(employeeEntity.getPassword(), employeeCreateDto.getPassword())) {
            employeeEntity.setName(employeeCreateDto.getPassword());
        }

        employeeService.updateEmployeeEntity(employeeEntity);
    }
}
