package com.santiago.AppDisney.dto.movies;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MoviesBaseDto {
    @JsonIgnore
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
