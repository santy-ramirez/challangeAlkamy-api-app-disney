package com.santiago.AppDisney.dto.movies;

import com.santiago.AppDisney.dto.genero.GeneroBaseDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MoviesQueryDto extends MoviesBaseDto{
    private GeneroBaseDto generoBaseDto;
    private Integer calification;


    public MoviesQueryDto(Long id, String title, String image, LocalDate createAt, GeneroBaseDto generoBaseDto, Integer calification) {
        super(id, title, image, createAt);
        this.generoBaseDto = generoBaseDto;
        this.calification = calification;
    }
}
