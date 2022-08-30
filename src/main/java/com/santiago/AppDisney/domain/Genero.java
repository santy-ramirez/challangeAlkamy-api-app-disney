package com.santiago.AppDisney.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@NoArgsConstructor
@Getter
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    private List<Movies> movies = new ArrayList<>();

    public Genero(Long id, String name, List<Movies> movies) {
        this.id = id;
        this.name = name;
        this.movies = movies;
    }
}
