package com.santiago.AppDisney.dto.movies;

import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.genero.GeneroBaseDto;
import com.santiago.AppDisney.dto.personage.PersonageBaseDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class MoviesDto extends MoviesBaseDto{

    private Set<PersonageBaseDto> characters = new HashSet<>();
    private GeneroBaseDto generoBaseDto;


    public MoviesDto(Long id, String title, Set<PersonageBaseDto> characters,GeneroBaseDto generoBaseDto) {
        super(id, title);
        this.characters = characters;
        this.generoBaseDto = generoBaseDto;
    }
}
