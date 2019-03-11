package com.project.employee.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    private String room_no;
    @OneToMany(mappedBy = "room")
    private Set<Employee> employees = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "level_id")
    private Level level;

    public Room(String room_no, Level level) {
        this.room_no = room_no;
        this.level = level;
    }
}
