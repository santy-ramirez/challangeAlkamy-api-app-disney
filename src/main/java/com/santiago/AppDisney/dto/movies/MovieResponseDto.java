package com.santiago.AppDisney.dto.movies;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MovieResponseDto extends MoviesBaseDto{
    private Integer calification;

    public MovieResponseDto(Integer calification) {
        this.calification = calification;
    }

    public MovieResponseDto(Long id, String title, String image, LocalDate createAt, Integer calification) {
        super(id, title, image, createAt);
        this.calification = calification;
    }
}
