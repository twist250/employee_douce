package com.project.employee.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String first_name;
    private String last_name;
    private String nationalID;
    private LocalDate start_date;
    private LocalDate birth_date;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "employee")
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Room room;
}
