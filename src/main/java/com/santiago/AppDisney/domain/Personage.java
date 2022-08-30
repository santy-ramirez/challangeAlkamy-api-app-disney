package com.santiago.AppDisney.domain;

import lombok.*;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
@Getter
@Setter
public class Personage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;

    @ManyToMany(mappedBy = "personages", fetch = FetchType.EAGER,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }
    )
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
