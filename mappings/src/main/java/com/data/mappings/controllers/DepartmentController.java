package com.data.mappings.controllers;

import com.data.mappings.entities.DepartmentEntity;
import com.data.mappings.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
@GetMapping("/{departmentId}")
    public DepartmentEntity getDepartmentById(@PathVariable Long departmentId)
    {
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentEntity createDepartment(@RequestBody DepartmentEntity departmentEntity)
    {
        return  departmentService.saveDepartment(departmentEntity);
    }

    @PutMapping("/{departmentId}/manager/{employeeId}")
    public DepartmentEntity assignManagerToDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId)
    {
        return departmentService.assignManagerToDepartment(departmentId,employeeId);
    }
    @GetMapping("/assignedDepartmentOfManager/{employeeId}")
    public DepartmentEntity getAssignedDepartmentOfManager(@PathVariable Long employeeId)
    {
        return departmentService.getAssignedDepartmentOfManager(employeeId);
    }
}
