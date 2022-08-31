package com.santiago.AppDisney.converter;


import com.santiago.AppDisney.domain.Movies;
import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.movies.MoviesBaseDto;
import com.santiago.AppDisney.dto.personage.PersonageBaseDto;
import com.santiago.AppDisney.dto.personage.PersonageDto;
import com.santiago.AppDisney.dto.personage.PersonageQueryDto;
import org.springframework.stereotype.Component;


import java.util.Set;
import java.util.stream.Collectors;


@Component
public class PersonageConverter {
    public PersonageBaseDto toDtoBase(Personage personage){
       PersonageBaseDto personageBaseDto = new PersonageBaseDto();
       personageBaseDto.setName(personage.getName());
       personageBaseDto.setImage(personage.getName());
       return personageBaseDto;

    }

    public PersonageDto toDto(Personage personage){
        PersonageDto personageDto = new PersonageDto();
        personageDto.setAge(personage.getAge());
        personageDto.setHistory(personage.getHistory());
        personageDto.setPeso(personage.getPeso());
        personageDto.setMovies(toListPersonageDto(personage.getMovies()));
    return personageDto;
    }

    public PersonageQueryDto toPersonageQueryDto(Personage personage){
        PersonageQueryDto personageQueryDto = new PersonageQueryDto();
        personageQueryDto.setAge(personage.getAge());
        personageQueryDto.setHistory(personage.getHistory());
        personageQueryDto.setPeso(personage.getPeso());
        personageQueryDto.setImage(personage.getImage());
        personageQueryDto.setName(personage.getName());
        return personageQueryDto;


    }

    public Personage toPersonageQueryEntity(PersonageQueryDto personageQueryDto){
        Personage personage = new Personage();
        personage.setName(personageQueryDto.getName());
        personage.setAge(personageQueryDto.getAge());
        personage.setHistory(personageQueryDto.getHistory());
        personage.setImage(personageQueryDto.getImage());
        personage.setPeso(personageQueryDto.getPeso());
        return personage;
    }

    public Set<MoviesBaseDto> toListPersonageDto(Set<Movies> moviesList){
        return moviesList.stream().map(movie -> new MoviesBaseDto(
                movie.getId(),
                movie.getTitle(),
                movie.getImage(),
                movie.getCreateAt()
                )

        ).collect(Collectors.toSet());
    }

}
