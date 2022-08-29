package com.santiago.AppDisney.domain;

import lombok.Data;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "movies_character",joinColumns = @JoinColumn(name="id_movies"),inverseJoinColumns = @JoinColumn(name="id_character"))
    private Set<Personage> characters = new HashSet<>();

    public Movies() {
    }
}
