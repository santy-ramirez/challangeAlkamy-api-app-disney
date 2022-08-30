package com.santiago.AppDisney.converter;

import com.santiago.AppDisney.domain.Genero;
import com.santiago.AppDisney.domain.Movies;
import com.santiago.AppDisney.dto.genero.GeneroBaseDto;
import com.santiago.AppDisney.dto.genero.GeneroDto;
import com.santiago.AppDisney.dto.movies.MoviesBaseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GeneroConverter {
    public GeneroBaseDto toGeneroBaseDto(Genero genero){
        return new GeneroBaseDto(
                genero.getId(),
                genero.getName());
    }

    public GeneroDto toGeneroDto(Genero genero){
        return new GeneroDto(
                genero.getId(),
                genero.getName(),
                toMoviesBaseDtoList(genero.getMovies()));
    }
    public List<MoviesBaseDto> toMoviesBaseDtoList(List<Movies> moviesList){
        return moviesList.stream().map(movies -> new MoviesBaseDto(
                movies.getId(),
                movies.getTitle()

                ))
                .collect(Collectors.toList());
    }

}
