package com.project.employee.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Role {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
    private Set<EmployeeRole> employeeRoles = new HashSet<>();
}
