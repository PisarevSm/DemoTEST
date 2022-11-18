package com.example.demobullsht.demotest.Service;

import java.util.*;

import com.example.demobullsht.demotest.Entity.*;
import com.example.demobullsht.demotest.Entity.Repository.*;
import com.example.demobullsht.demotest.Exception.*;
import com.example.demobullsht.demotest.Repository.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity getEmployee(Long employeeId) {
        return employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new NotFoundException("Сотрудник не найден"));
    }

    public EmployeeEntity getEmployee(String employeeLogin) {
        return employeeRepository
                .findByLogin(employeeLogin)
                .orElseThrow(() -> new NotFoundException("Сотрудник не найден"));
    }

    public void setNewEmployee(EmployeeEntity employee) {
        Optional<EmployeeEntity> employeeOptional = employeeRepository
                .findByLogin(employee.getLogin());
        if (employeeOptional.isPresent()) {
            throw new NotFoundException("Сотрудник не найден");
        }
        employeeRepository.save(employee);
    }

    public void updateEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
    }

    public void deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            throw new NotFoundException("Сотрудник не найден");
        }
        employeeRepository.deleteById(employeeId);
    }
}
