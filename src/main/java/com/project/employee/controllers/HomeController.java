package com.project.employee.controllers;

import com.project.employee.domains.Employee;
import com.project.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final EmployeeService employeeService;

    @Autowired
    public HomeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(name = "/")
    public String index() {
        return "redirect:/login";
    }

    @PostMapping(name = "/employee")
    public String saveEmployee(@ModelAttribute Employee employee, Model model) {

        if (employeeService.createEmployee(employee) != null) {
            model.addAttribute("response", "Saved Successfully");
            return "index";
        }
        model.addAttribute("response", "They was an error in saving");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
