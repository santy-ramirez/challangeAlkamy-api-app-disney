package com.santiago.AppDisney.dto.characters;

import com.santiago.AppDisney.domain.Movies;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
public class PersonageDto extends PersonageBaseDto {
   private String name;



   public PersonageDto(Long id, String name) {
      super(id);
      this.name = name;
   }
//   private Set<Movies> movies = new HashSet<>();


}
