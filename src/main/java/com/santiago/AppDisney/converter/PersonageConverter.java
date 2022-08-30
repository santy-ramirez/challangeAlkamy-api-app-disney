package com.santiago.AppDisney.converter;


import com.santiago.AppDisney.domain.Movies;
import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.movies.MoviesBaseDto;
import com.santiago.AppDisney.dto.personage.PersonageBaseDto;
import com.santiago.AppDisney.dto.personage.PersonageDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class PersonageConverter {
    public PersonageBaseDto toDtoBase(Personage personage){
        return new PersonageBaseDto(
                personage.getId(),
                personage.getName());

    }

    public PersonageDto toDto(Personage personage){
        return new PersonageDto(
                personage.getId(),
                personage.getName(),
                toListPersonageDto(personage.getMovies()));

    }

    public Set<MoviesBaseDto> toListPersonageDto(Set<Movies> moviesList){
        return moviesList.stream().map(movie -> new MoviesBaseDto(
                movie.getId(),
                movie.getTitle()

                )

        ).collect(Collectors.toSet());
    }


}
