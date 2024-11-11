package com.data.mappings.services;

import com.data.mappings.entities.EmployeeEntity;
import com.data.mappings.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity getEmployeeById(Long employeeId) {
       return employeeRepository.findById(employeeId).orElse(null);
    }

    public EmployeeEntity saveNewEmployee(EmployeeEntity employeeEntity) {
        return  employeeRepository.save(employeeEntity);
    }
}
