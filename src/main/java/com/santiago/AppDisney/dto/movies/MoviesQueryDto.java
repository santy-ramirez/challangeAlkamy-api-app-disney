package com.santiago.AppDisney.dto.movies;

import com.santiago.AppDisney.dto.genero.GeneroBaseDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MoviesQueryDto extends MoviesBaseDto{
    private GeneroBaseDto genero;
    @Max(5)
    @Min(1)
    private Integer calification;


    public MoviesQueryDto(Long id, String title, String image, LocalDate createAt, GeneroBaseDto generoBaseDto, Integer calification) {
        super(id, title, image, createAt);
        this.genero = generoBaseDto;
        this.calification = calification;

    }
}
