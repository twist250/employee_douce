package com.project.employee.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Division {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "division")
    private Set<Position> positions = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;
}
