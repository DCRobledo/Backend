package com.drobledo.springboot.cruddemo.controller;

import com.drobledo.springboot.cruddemo.entity.Employee;
import com.drobledo.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> listOfEmployees = employeeService.findAll();
        model.addAttribute("employees", listOfEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee newEmployee = new Employee();
        model.addAttribute("employee", newEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
        Employee targetEmployee = employeeService.findById(id);

        model.addAttribute("employee", targetEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
}
