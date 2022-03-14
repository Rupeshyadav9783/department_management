package com.example.employee.service;

import com.example.employee.entity.Employee;
import com.example.employee.exception.EmployeeServiceException;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public static final String HASH_KEY = "Employee";

    @Autowired
    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }

    public List<Employee> saveEmployees(List<Employee> employees){
        return repository.saveAll(employees);
    }

    public List<Employee> getEmployees(){
        return new ArrayList<>(repository.findAll());
    }

    public Employee getEmployeesById(int id){
        System.out.println("Called getEmployeesById() from DB");
        return repository.findById(id).orElseThrow(() -> new EmployeeServiceException("User not Found: "+id));
    }

    public Employee getEmployeesByName(String name){
        return repository.findByName(name);
    }

    public String deleteEmployee(int id){
        repository.deleteById(id);
        return "Employee removed !!" + id;
    }

    public Employee updateEmployee(Employee employee){
        Employee existingEmployee=repository.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setExp(employee.getExp());
        return repository.save(existingEmployee);
    }
}
