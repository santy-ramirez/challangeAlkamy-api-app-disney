package com.santiago.AppDisney.dto.characters;

import com.santiago.AppDisney.domain.Movies;
import com.santiago.AppDisney.dto.MoviesDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
public class CharacterDto  {

   private Set<Movies> movies = new HashSet<>();


}
