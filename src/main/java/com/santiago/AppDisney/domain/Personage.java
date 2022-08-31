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
    private Integer age;
    private Long peso;
    private String history;

    private String image;
    @ManyToMany(mappedBy = "personages", fetch = FetchType.EAGER,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }
    )
    private Set<Movies> movies = new HashSet<>();

    public Personage() {
    }

    public Personage(Long id, String name,Integer age,Long peso,String history, Set<Movies> movies) {
        Id = id;
        this.name = name;
        this.age = age;
        this.movies = movies;
        this.peso = peso;
        this.history = history;
    }
}
