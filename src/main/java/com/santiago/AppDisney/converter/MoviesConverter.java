package com.santiago.AppDisney.converter;

import com.santiago.AppDisney.domain.Movies;
import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.movies.MoviesBaseDto;
import com.santiago.AppDisney.dto.movies.MoviesDto;
import com.santiago.AppDisney.dto.personage.PersonageBaseDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MoviesConverter {

    public MoviesBaseDto toMovieBaseDto(Movies movies){
        return new MoviesBaseDto(
                movies.getId(),
                movies.getTitle());
    }
    public MoviesDto toMoviesDto(Movies movies){
        return new MoviesDto(
                movies.getId(),
                movies.getTitle(),
               personageBaseDtoList( movies.getPersonages())
        );
    }

    public Set<PersonageBaseDto> personageBaseDtoList(Set<Personage> personages){
        return personages.stream().
                map(personage -> new PersonageBaseDto(
                        personage.getId(),
                        personage.getName()))
                .collect(Collectors.toSet());
    }

    public Movies toMovieEntity(MoviesBaseDto moviesDto){
        return new Movies(
                moviesDto.getId(),
                moviesDto.getTitle()

        );
    }


}
