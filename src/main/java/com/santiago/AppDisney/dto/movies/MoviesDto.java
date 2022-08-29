package com.santiago.AppDisney.dto.movies;

import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.personage.PersonageBaseDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class MoviesDto extends MoviesBaseDto{

    private Set<PersonageBaseDto> characters = new HashSet<>();

    public MoviesDto(Long id, String title, Set<PersonageBaseDto> characters) {
        super(id, title);
        this.characters = characters;
    }
}
