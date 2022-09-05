package com.santiago.AppDisney.controller;


import com.santiago.AppDisney.dto.movies.MovieResponseDto;
import com.santiago.AppDisney.dto.movies.MoviesDto;
import com.santiago.AppDisney.dto.movies.MoviesQueryDto;
import com.santiago.AppDisney.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Validated
@RestController
@RequestMapping("api/v1/movies")
public class MoviesController {
    private MoviesService moviesService;

    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @PostMapping
    public ResponseEntity<MovieResponseDto> createMovies(@RequestBody @Valid  MoviesQueryDto movies){
        return new ResponseEntity<>(moviesService.createMovie(movies), HttpStatus.CREATED);

    }

    @PostMapping("{idMovie}/personage/{idPersonage}")
    public ResponseEntity<MoviesDto> addPersonage(
            @PathVariable @Valid @Positive Long idMovie,
            @PathVariable @Valid @Positive Long idPersonage) {
        return new ResponseEntity<>(moviesService.addPersonage(idMovie,idPersonage),HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<MovieResponseDto> deleteMovie(@PathVariable Long id,@RequestBody MoviesQueryDto moviesQueryDto){
        return new ResponseEntity<>(moviesService.updateMovie(id,moviesQueryDto),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id){
        return new ResponseEntity<>(moviesService.deleteMovie(id),HttpStatus.OK);

    }

    @DeleteMapping("{idMovie}/personage/{idPersonage}")
    public  ResponseEntity<MoviesDto>deletePersonage(
            @PathVariable @Valid @Positive Long idMovie,
            @PathVariable @Valid @Positive Long idPersonage){
        return new ResponseEntity<>(moviesService.deletePersonage(idMovie,idPersonage),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getAllMovies(@RequestParam(required = false) @Valid @Size(max = 20, min = 3) String name,
                                       @RequestParam(required = false, defaultValue = "1") @Valid @Positive int page
                                        ){
        return new ResponseEntity<>(moviesService.getAllMovie(name,page),HttpStatus.OK) ;
    }
}
