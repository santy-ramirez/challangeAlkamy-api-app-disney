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

    @ManyToMany(mappedBy = "characters", fetch = FetchType.EAGER)
    private Set<Movies> movies = new HashSet<>();

    public Characters() {
    }

    public Characters(Long id_character, String name,  Set<Movies> movies) {
        Id_character = id_character;
        this.name = name;

        this.movies = movies;
    }

    public Characters(Long id_character, String name) {
        Id_character = id_character;
        this.name = name;

    }
}
