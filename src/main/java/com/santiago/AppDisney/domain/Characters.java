package com.santiago.AppDisney.domain;

import lombok.Data;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Characters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id_character;
    private String name;

    @ManyToMany(mappedBy = "characters")
    private Set<Movies> movies = new HashSet<>();

    public Characters() {
    }
}
