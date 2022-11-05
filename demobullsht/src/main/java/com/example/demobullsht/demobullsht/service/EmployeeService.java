package com.example.demobullsht.demobullsht.service;

import com.example.demobullsht.demobullsht.exception.EmployeeNotFoundException;
import com.example.demobullsht.demobullsht.repository.EmployeeRepository;
import com.example.demobullsht.demobullsht.entity.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    /*@Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }*/

    public List<EmployeeEntity> getEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow( () -> new EmployeeNotFoundException("Пользователь не найден!"));
    }

    public EmployeeEntity getEmployeeByLogin(String login) {
        EmployeeEntity employeeEntityByLogin = employeeRepository.findEmployeeEntityByLogin(login);
        if (employeeEntityByLogin == null) {
            throw new RuntimeException("Пользователь с данным логином не найден");
        } else {
            return employeeEntityByLogin;
        }
    }

    public void addNewEmployeeEntity(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
    }

    // Перенести проверку в контроллер
    public void updateEmployeeEntity(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
    }

    public void deleteEmployeeEntity(Long id) {
          boolean exists = employeeRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "employee with id " + id + "doesn't exist");
        }
        employeeRepository.deleteById(id);
    }
}
