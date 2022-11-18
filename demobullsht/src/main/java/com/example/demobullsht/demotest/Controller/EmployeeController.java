package com.example.demobullsht.demotest.Controller;

import java.util.*;

import com.example.demobullsht.demotest.DTO.*;
import com.example.demobullsht.demotest.Entity.*;
import com.example.demobullsht.demotest.Mapper.*;
import com.example.demobullsht.demotest.Service.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("/")
    public List<EmployeeDTO> getAllEntity() {
        List<EmployeeEntity> entityList = employeeService.getAllEmployee();
        return entityList
                .stream()
                .map(EmployeeMapper::getEntityToDTO)
                .toList();
    }


    @GetMapping(path = "/id={employeeId}")
    public EmployeeDTO getFindById(@PathVariable("employeeId") Long employeeId) {
        return EmployeeMapper.getEntityToDTO(employeeService.getEmployee(employeeId));
    }

    @GetMapping(path = "/login={employeeLogin}")
    public EmployeeDTO getFindByLogin(@PathVariable("employeeLogin") String employeeLogin) {
        return EmployeeMapper.getEntityToDTO(employeeService.getEmployee(employeeLogin));
    }


    @PostMapping
    public void postEntity(@RequestBody EmployeeCreateDTO employeeCreateDTO) {
        employeeService.setNewEmployee(EmployeeMapper.getCreateDTOToEntity(employeeCreateDTO));
    }


    @PutMapping(path = "/{employeeId}")
    public void updateEntity(
            @PathVariable("employeeId") Long employeeId,
            @RequestBody EmployeeCreateDTO employeeCreateDTO) {

        EmployeeEntity employeeEntity = employeeService.getEmployee(employeeId);

        if (employeeCreateDTO.getName() != null &&
                employeeCreateDTO.getName().length() > 0 &&
                !Objects.equals(employeeEntity.getName(), employeeCreateDTO.getName())) {
            employeeEntity.setName(employeeCreateDTO.getName());
        }
        if (employeeCreateDTO.getLogin() != null &&
                employeeCreateDTO.getLogin().length() > 0 &&
                !Objects.equals(employeeEntity.getLogin(), employeeCreateDTO.getLogin())) {
            employeeEntity.setLogin(employeeCreateDTO.getLogin());
        }
        if (employeeCreateDTO.getPassword() != null &&
                employeeCreateDTO.getPassword().length() > 0 &&
                !Objects.equals(employeeEntity.getPassword(), employeeCreateDTO.getPassword())) {
            employeeEntity.setPassword(employeeCreateDTO.getPassword());
        }
        if (employeeCreateDTO.getEmail() != null &&
                employeeCreateDTO.getEmail().length() > 0 &&
                !Objects.equals(employeeEntity.getEmail(), employeeCreateDTO.getEmail())) {
            employeeEntity.setEmail(employeeCreateDTO.getEmail());
        }
        employeeService.updateEmployee(employeeEntity);
    }


    @DeleteMapping(path = "/{employeeId}")
    public void deleteEntity(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

}
