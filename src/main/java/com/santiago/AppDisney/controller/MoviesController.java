package com.santiago.AppDisney.controller;

import com.santiago.AppDisney.domain.Movies;
import com.santiago.AppDisney.dto.movies.MoviesBaseDto;
import com.santiago.AppDisney.dto.movies.MoviesDto;
import com.santiago.AppDisney.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/movies")
public class MoviesController {
    private MoviesService moviesService;

    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @PostMapping
    public ResponseEntity<MoviesBaseDto> createMovies(@RequestBody MoviesBaseDto moviesBaseDto){
        return new ResponseEntity<>(moviesService.createMovie(moviesBaseDto), HttpStatus.CREATED);

    }

    @PostMapping("{idMovie}/personage/{idPersonage}")
    public ResponseEntity<String> addPersonage(
            @PathVariable Long idMovie,
            @PathVariable Long idPersonage
    ) throws Exception {
 return new ResponseEntity<>(moviesService.getList(idMovie,idPersonage),HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity getAllMovies(){
        return new ResponseEntity<>(moviesService.getAllMovie(),HttpStatus.OK) ;
    }
}
