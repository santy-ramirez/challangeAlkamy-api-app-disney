package com.santiago.AppDisney.dto.personage;

import com.santiago.AppDisney.dto.movies.MoviesBaseDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
public class PersonageDto extends PersonageBaseDto {

    private Integer age;
    private Long peso;
    private String history;
  private Set<MoviesBaseDto> movies = new HashSet<>();



   public PersonageDto( String name,String image,Integer age,Long peso,String history, Set<MoviesBaseDto> movies) {
      super( name,image);
      this.movies = movies;
      this.age = age;
      this.peso = peso;
      this.history = history;
   }
}
