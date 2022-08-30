package com.santiago.AppDisney.domain;

import lombok.*;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    @ManyToMany(cascade ={
            CascadeType.PERSIST,CascadeType.MERGE
    },fetch = FetchType.LAZY)
    @JoinTable(name = "movies_personages",joinColumns = @JoinColumn(name="id_movies"),inverseJoinColumns = @JoinColumn(name="id_personages"))
    private Set<Personage> personages = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Genero genero;

    public Movies(Long id, String title, Set<Personage> personages, Genero genero) {
        Id = id;
        this.title = title;
        this.personages = personages;
        this.genero = genero;
    }

    public void addPersonage(Personage personage){
        this.personages.add(personage);
        personage.getMovies().add(this);
    }
    public void  remove(Long idPersonage){
        Personage personage = this.personages.stream().filter(personage1 -> personage1.getId() == idPersonage).findFirst().orElse(null);
        if(personage != null){
            this.personages.remove(personage);
            personage.getMovies().remove(this);
        }



    }

}
