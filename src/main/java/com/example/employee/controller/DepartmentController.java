package com.example.employee.controller;

import com.example.employee.entity.Department;
import com.example.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableCaching
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        super();
        this.departmentService = departmentService;
    }

    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @PostMapping("/addDepartments")
    public List<Department> addDepartments(@RequestBody List<Department> departments){
        return departmentService.saveDepartments(departments);
    }

    @GetMapping("/departments")
    public List<Department> findAllDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/departmentById/{id}")
    @Cacheable(key = "#id",value = "Department")
    public Department findDepartmentById(@PathVariable Integer id){
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/updateDepartment")
    @CachePut(key = "#id",value = "Department")
    public Department updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    @CacheEvict(key = "#id",value = "Department")
    public String deleteDepartment(@PathVariable Integer id){
        return departmentService.deleteDepartment(id);
    }

}
