package com.example.employee.service;

import com.example.employee.entity.Department;
import com.example.employee.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    public static final String HASH_KEY = "Department";

    @Autowired
    private DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department saveDepartment(Department department){
        return (Department) repository.save(department);
    }

    public List<Department> saveDepartments(List<Department> departments){
        return repository.saveAll(departments);
    }

    public List<Department> getDepartments(){
        return new ArrayList<>(repository.findAll());
    }

    public Department getDepartmentById(Integer id) {
        System.out.println("Called getDepartmentById() from DB");
        return repository.findById(id).orElse(null);
    }

    public String deleteDepartment(Integer id){
        repository.deleteById(id);
        return "Department removed!!" + id;
    }

    public Department updateDepartment(Department department){
        Department existingDepartment = (Department) repository.findById(department.getId()).orElse(null);
        existingDepartment.setName(department.getName());
        existingDepartment.setDescription(department.getDescription());
        return (Department) repository.save(existingDepartment);
    }
}
