package com.santiago.AppDisney.controller;


import com.santiago.AppDisney.domain.Movies;
import com.santiago.AppDisney.dto.movies.MoviesBaseDto;
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
    public ResponseEntity<MoviesQueryDto> createMovies(@RequestBody @Valid  MoviesQueryDto movies){
        return new ResponseEntity<>(moviesService.createMovie(movies), HttpStatus.CREATED);

    }

    @PostMapping("{idMovie}/personage/{idPersonage}")
    public ResponseEntity<MoviesDto> addPersonage(
            @PathVariable @Valid @Positive Long idMovie,
            @PathVariable @Valid @Positive Long idPersonage) {
        return new ResponseEntity<>(moviesService.getList(idMovie,idPersonage),HttpStatus.CREATED);

    }

    @DeleteMapping("{idMovie}/personage/{idPersonage}")
    public  ResponseEntity<MoviesDto>deletePersonage(
            @PathVariable @Valid @Positive Long idMovie,
            @PathVariable @Valid @Positive Long idPersonage){
        return new ResponseEntity<>(moviesService.deletePersonage(idMovie,idPersonage),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getAllMovies(@RequestParam(required = false) @Valid @Size(max = 20, min = 3) String name){
        return new ResponseEntity<>(moviesService.getAllMovie(name),HttpStatus.OK) ;
    }
}
