package com.service;

import com.entity.Employee;
import com.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public String addEmployee(Employee employee){
    repository.save(employee);
        return "Successfully saved";
    }

    public List<Employee>getEmployee(){
      return   repository.findAll();
    }

    public Employee updateEmployee(long id){
        Optional<Employee> employee = repository.findById(id);
        return employee.orElse(null);
    }

    public void deleteEmployee(Long id){
        repository.deleteById(id);
    }
}
