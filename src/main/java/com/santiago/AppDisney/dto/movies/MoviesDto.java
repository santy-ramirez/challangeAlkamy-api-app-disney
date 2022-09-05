package com.santiago.AppDisney.dto.movies;

import com.santiago.AppDisney.dto.genero.GeneroBaseDto;
import com.santiago.AppDisney.dto.personage.PersonageBaseDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class MoviesDto extends MoviesBaseDto{

    private Set<PersonageBaseDto> characters = new HashSet<>();
    private GeneroBaseDto genero;
    private Integer calification;

    public MoviesDto(Long id, String title, String image, LocalDate createAt,Integer calification, Set<PersonageBaseDto> characters, GeneroBaseDto generoBaseDto) {
        super(id, title,image,createAt);
        this.characters = characters;
        this.genero = generoBaseDto;
        this.calification = calification;
    }


}
