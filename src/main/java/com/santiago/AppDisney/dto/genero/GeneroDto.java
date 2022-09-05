package com.santiago.AppDisney.dto.genero;

import com.santiago.AppDisney.dto.movies.MoviesBaseDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class GeneroDto extends GeneroBaseDto{

    private List<MoviesBaseDto> movies = new ArrayList<>();

    public GeneroDto(Long id, String name, List<MoviesBaseDto> moviesBaseDtoList) {
        super(id, name);
        this.movies = moviesBaseDtoList;
    }
}
