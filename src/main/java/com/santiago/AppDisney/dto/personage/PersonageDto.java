package com.santiago.AppDisney.dto.personage;

import com.santiago.AppDisney.dto.movies.MoviesBaseDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
public class PersonageDto extends PersonageBaseDto {


  private Set<MoviesBaseDto> movies = new HashSet<>();



   public PersonageDto(Long id, String name, Set<MoviesBaseDto> movies) {
      super(id, name);
      this.movies = movies;
   }
}
