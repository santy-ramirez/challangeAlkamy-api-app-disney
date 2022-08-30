package com.santiago.AppDisney.controller;

import com.santiago.AppDisney.domain.Genero;
import com.santiago.AppDisney.dto.genero.GeneroBaseDto;
import com.santiago.AppDisney.dto.genero.GeneroDto;
import com.santiago.AppDisney.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/genero")
public class GeneroController {
    private final GeneroService generoService;

    @Autowired
    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @PostMapping
    public GeneroBaseDto createGenero(@RequestBody Genero genero){
    return generoService.createGenero(genero);
    }

    @PutMapping("{id}")
    public GeneroBaseDto updateGenero(@PathVariable Long id, Genero genero){
        return generoService.updateGenero(id,genero);
    }
    @GetMapping
    public List<GeneroDto> getAllGeneros(){
        return generoService.getAllGenero();
    }

}
