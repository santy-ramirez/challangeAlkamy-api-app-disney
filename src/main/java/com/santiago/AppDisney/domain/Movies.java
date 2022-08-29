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
    @ManyToMany(cascade ={
            CascadeType.PERSIST,CascadeType.MERGE
    },fetch = FetchType.LAZY)
    @JoinTable(name = "movies_character",joinColumns = @JoinColumn(name="id_movies"),inverseJoinColumns = @JoinColumn(name="id_character"))
    private Set<Personage> characters = new HashSet<>();

    public Movies() {
    }

    public Movies(Long id, String title) {
        Id = id;
        this.title = title;
    }

    public Movies(Long id, String title, Set<Personage> characters) {
        Id = id;
        this.title = title;
        this.characters = characters;
    }

    public void addPersonage(Personage personage){
        this.characters.add(personage);
        personage.getMovies().add(this);
    }
}
