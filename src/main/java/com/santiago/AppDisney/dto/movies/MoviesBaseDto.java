package com.santiago.AppDisney.dto.movies;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MoviesBaseDto {
    private Long Id;
    private String title;

    public MoviesBaseDto(Long id, String title) {
        Id = id;
        this.title = title;
    }
}
