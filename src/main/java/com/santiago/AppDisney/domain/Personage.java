package com.santiago.AppDisney.domain;

import lombok.Data;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Personage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;

    @ManyToMany(mappedBy = "characters", fetch = FetchType.EAGER)
    private Set<Movies> movies = new HashSet<>();

    public Personage() {
    }

    public Personage(Long id, String name, Set<Movies> movies) {
        this.Id = id;
        this.name = name;

        this.movies = movies;
    }

    public Personage(Long id,String name) {
        this.Id = id;
        this.name = name;

    }
}
