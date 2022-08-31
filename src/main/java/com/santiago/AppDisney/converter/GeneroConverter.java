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


    public GeneroBaseDto toTestGeneroDto(Genero genero){
        GeneroBaseDto generoBaseDto = new GeneroBaseDto();
        generoBaseDto.setId(genero.getId());
        generoBaseDto.setName(genero.getName());
        return generoBaseDto;
    }

    public  Genero toTestGeneroEntity(GeneroBaseDto generoBaseDto){
        Genero genero = new Genero();
        genero.setId(genero.getId());
        genero.setName(generoBaseDto.getName());
        return genero;
    }
    public  GeneroDto toTestCompleteGeneroDto(Genero genero){
        GeneroDto generoDto = new GeneroDto();
        generoDto.setId(generoDto.getId());
        generoDto.setName(genero.getName());
        generoDto.setMoviesBaseDtoList(toMoviesBaseDtoList(genero.getMovies()));
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
