package com.example.employee.controller;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableCaching
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        super();
        this.service = service;
    }

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        return service.saveEmployees(employees);
    }
    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return service.getEmployees();
    }

    @GetMapping("/employeeById/{id}")
    @Cacheable(key = "#id",value = "Employee")
    public Employee findEmployeeById(@PathVariable int id){
        return service.getEmployeesById(id);

    }
    @GetMapping("/employeeByName/{name}")
    public Employee findEmployeeByName(@PathVariable String name){
        return service.getEmployeesByName(name);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }
    @DeleteMapping("/delete/{id}")
    @CacheEvict(key = "#id",value = "Employee")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }
}
