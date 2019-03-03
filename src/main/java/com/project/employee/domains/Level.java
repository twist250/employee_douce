package com.project.employee.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Level {
    @Id
    @GeneratedValue
    private Long id;
    private String level_name;

    @OneToMany(mappedBy = "level",fetch = FetchType.LAZY)
    private Set<Room> rooms = new HashSet<>();
}
