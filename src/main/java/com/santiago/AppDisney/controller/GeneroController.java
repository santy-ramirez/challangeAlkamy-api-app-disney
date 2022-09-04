package com.santiago.AppDisney.controller;

import com.santiago.AppDisney.domain.Genero;
import com.santiago.AppDisney.dto.genero.GeneroBaseDto;
import com.santiago.AppDisney.dto.genero.GeneroDto;
import com.santiago.AppDisney.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/v1/genero")
public class GeneroController {
    private final GeneroService generoService;

    @Autowired
    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @PostMapping
    public ResponseEntity<GeneroBaseDto>  createGenero(@RequestBody @Valid GeneroBaseDto genero){
    return new ResponseEntity<>(generoService.createGenero(genero), HttpStatus.CREATED) ;
    }

    @PutMapping("{id}")
    public ResponseEntity<GeneroBaseDto>  updateGenero(@PathVariable  @Valid @Positive Long id,
                                      @RequestBody @Valid GeneroBaseDto genero){
        return new ResponseEntity<>(generoService.updateGenero(id,genero),HttpStatus.OK) ;
    }
    @GetMapping
    public ResponseEntity<List<GeneroDto>>  getAllGeneros(){
        return new ResponseEntity<>(generoService.getAllGenero(),HttpStatus.OK);
    }

}
