package com.drobledo.springboot.cruddemo.rest;

import com.drobledo.springboot.cruddemo.entity.Employee;
import com.drobledo.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @Autowired
    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> GetAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee GetEmployeeById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee AddEmployee(Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee UpdateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void DeleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
    }
}
