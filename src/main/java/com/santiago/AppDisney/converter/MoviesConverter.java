package com.santiago.AppDisney.converter;

import com.santiago.AppDisney.domain.Movies;
import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.movies.MovieResponseDto;
import com.santiago.AppDisney.dto.movies.MoviesBaseDto;
import com.santiago.AppDisney.dto.movies.MoviesDto;
import com.santiago.AppDisney.dto.movies.MoviesQueryDto;
import com.santiago.AppDisney.dto.personage.PersonageBaseDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MoviesConverter {
GeneroConverter generoConverter = new GeneroConverter();
    public MoviesBaseDto toMovieBaseDto(Movies movies){
       MoviesBaseDto moviesBaseDto = new MoviesBaseDto();
       moviesBaseDto.setCreateAt(movies.getCreateAt());
       moviesBaseDto.setImage(movies.getImage());
       moviesBaseDto.setTitle(movies.getTitle());
       return moviesBaseDto;
    }
    public MoviesDto toMoviesDto(Movies movies){
       MoviesDto moviesObject = new MoviesDto();
       moviesObject.setCalification(movies.getCalification());
       moviesObject.setCreateAt(movies.getCreateAt());
       moviesObject.setTitle(movies.getTitle());
       moviesObject.setImage(movies.getImage());
       moviesObject.setGenero(generoConverter.toGeneroDto(movies.getGenero()));
       moviesObject.setCharacters(personageBaseDtoList(movies.getPersonages()));
      return moviesObject;
    }
    public Set<PersonageBaseDto> personageBaseDtoList(Set<Personage> personages){
        return personages.stream().
                map(personage -> new PersonageBaseDto(
                        personage.getName(),
                        personage.getImage()
                        ))
                .collect(Collectors.toSet());
    }

    public MoviesQueryDto toMoviesQueryDto(Movies movies){
        MoviesQueryDto moviesQueryDto = new MoviesQueryDto();
        moviesQueryDto.setGenero(generoConverter.toGeneroDto( movies.getGenero()));
        moviesQueryDto.setCalification(movies.getCalification());
        moviesQueryDto.setCreateAt(movies.getCreateAt());
        moviesQueryDto.setTitle(movies.getTitle());
        moviesQueryDto.setImage(movies.getImage());
        return moviesQueryDto;
    }

    public  Movies toMovieQueryEntity(MoviesQueryDto moviesQueryDto){
        Movies movies = new Movies();
        movies.setGenero(generoConverter.toGeneroEntity(moviesQueryDto.getGenero()));
        movies.setImage(moviesQueryDto.getImage());
        movies.setCalification(moviesQueryDto.getCalification());
        movies.setTitle(moviesQueryDto.getTitle());
        movies.setCreateAt(moviesQueryDto.getCreateAt());
        return movies;
    }

    public MovieResponseDto toMovieResponseDto(Movies movies){
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setTitle(movies.getTitle());
        movieResponseDto.setCalification(movies.getCalification());
        movieResponseDto.setImage(movies.getImage());
        movieResponseDto.setCreateAt(movies.getCreateAt());
        return movieResponseDto;
    }

}
