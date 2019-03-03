package com.project.employee.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Position {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;
}
