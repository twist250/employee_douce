package com.project.employee;

import com.project.employee.domains.*;
import com.project.employee.repositories.DepartmentRepository;
import com.project.employee.repositories.DivisionRepository;
import com.project.employee.repositories.EmployeeRepository;
import com.project.employee.repositories.PositionRepository;
import com.project.employee.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class EmployeeApplication implements Runnable{
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DivisionRepository divisionRepository;
    @Autowired
    PositionRepository positionRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Override
    public void run() {
        Employee employee = new Employee();
        employee.setBirth_date(LocalDate.now());
        employee.setFirst_name("Tello");
        employee.setLast_name("douce");
        employee.setNationalID("12345678");
        employee.setRoom(new Room("1",new Level("admin")));
        employee.setPassword(SecurityUtility.passwordEncoder().encode("12345"));
        employeeRepository.save(employee);

        Department department = new Department();
        department.setDescription("human resources");
        department.setName("HR");
        departmentRepository.save(department);

        Division division = new Division();
        division.setDescription("first division");
        division.setDepartment(department);
        division.setName("first division name");
        divisionRepository.save(division);


        Position position = new Position();
        position.setDescription("First Position");
        position.setName("first position name");
        position.setDivision(division);
        position.setEmployee(employee);
        positionRepository.save(position);

        EmployeeRole employeeRole = new EmployeeRole();
        employeeRole.setEmployee(employee);
        Role role = new Role();
        role.setName("ADMIN");
        employeeRole.setRole(role);
        employee.setEmployeeRole(employeeRole);
        employeeRepository.saveAndFlush(employee);
    }
}
