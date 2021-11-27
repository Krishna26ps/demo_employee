package com.Controller;

import com.entity.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/add_Emp")
    public String addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }

    @GetMapping("/get_Emp")
    public List<Employee> getEmployee(){
        return service.getEmployee();

    }

    @PutMapping("/update_Emp/{id}")
    public String updateEmployee(@PathVariable long id, @RequestBody Employee employee){
      Employee emp =service.updateEmployee(id);
      emp.setName(employee.getName());
      emp.setAge(employee.getAge());
      emp.setDept(employee.getDept());
      service.addEmployee(emp);
      return "Successfully updated";
    }

    @DeleteMapping("/delete_Emp/{id}")
    public String deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return "Successfully deleted";
    }

}
