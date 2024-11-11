package com.data.mappings.controllers;

import com.data.mappings.entities.EmployeeEntity;
import com.data.mappings.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId)
    {
        return employeeService.getEmployeeById(employeeId);
    }


    @PostMapping
    public EmployeeEntity saveNewEmployee(@RequestBody EmployeeEntity employeeEntity)
    {
        return employeeService.saveNewEmployee(employeeEntity);
    }

}
