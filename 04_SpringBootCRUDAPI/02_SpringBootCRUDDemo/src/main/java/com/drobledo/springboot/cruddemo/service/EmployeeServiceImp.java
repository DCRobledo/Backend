package com.drobledo.springboot.cruddemo.service;

import com.drobledo.springboot.cruddemo.dao.EmployeeRepository;
import com.drobledo.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee targetEmployee = null;

        if (optionalEmployee.isPresent()) {
            targetEmployee = optionalEmployee.get();
        }
        else {
            throw new RuntimeException("Didn't found any employee with id - " + id);
        }

        return targetEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}