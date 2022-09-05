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


    public GeneroBaseDto toGeneroDto(Genero genero){
        GeneroBaseDto generoBaseDto = new GeneroBaseDto();
        generoBaseDto.setId(genero.getId());
        generoBaseDto.setName(genero.getName());
        return generoBaseDto;
    }

    public  Genero toGeneroEntity(GeneroBaseDto generoBaseDto){
        Genero genero = new Genero();
        genero.setId(generoBaseDto.getId());
        genero.setName(generoBaseDto.getName());
        return genero;
    }
    public  GeneroDto toCompleteGeneroDto(Genero genero){
        GeneroDto generoDto = new GeneroDto();
        generoDto.setId(genero.getId());
        generoDto.setName(genero.getName());
        generoDto.setMovies(toMoviesBaseDtoList(genero.getMovies()));
        return generoDto;
    }
    public List<MoviesBaseDto> toMoviesBaseDtoList(List<Movies> moviesList){
        return moviesList.stream().map(movies -> new MoviesBaseDto(
                        movies.getId(),
                        movies.getTitle(),
                        movies.getImage(),
                        movies.getCreateAt()

                ))
                .collect(Collectors.toList());
    }

}
