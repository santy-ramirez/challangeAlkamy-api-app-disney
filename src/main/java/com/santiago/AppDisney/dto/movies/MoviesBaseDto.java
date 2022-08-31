package com.santiago.AppDisney.dto.movies;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MoviesBaseDto {
    private Long Id;
    private String title;
    private String image;
    private LocalDate createAt;

    public MoviesBaseDto(Long id, String title,String image,LocalDate createAt) {
        Id = id;
        this.title = title;
        this.image = image;
        this.createAt = createAt;

    }
}
