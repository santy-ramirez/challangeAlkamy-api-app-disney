package com.santiago.AppDisney.service;

import com.santiago.AppDisney.converter.GeneroConverter;
import com.santiago.AppDisney.domain.Genero;
import com.santiago.AppDisney.dto.genero.GeneroBaseDto;
import com.santiago.AppDisney.dto.genero.GeneroDto;
import com.santiago.AppDisney.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneroService {
    private final GeneroRepository generoRepository;
    private final GeneroConverter generoConverter;

    @Autowired
    public GeneroService(GeneroRepository generoRepository, GeneroConverter generoConverter) {
        this.generoRepository = generoRepository;
        this.generoConverter = generoConverter;
    }

    public GeneroBaseDto createGenero(Genero genero){

        generoRepository.save(genero);
        return generoConverter.toGeneroBaseDto(genero);
    }

    public GeneroBaseDto updateGenero(Long id,Genero genero){
        Genero generoEntity = generoRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Not found genero ")
        );
        generoEntity.setId(id);
        generoEntity.setName(genero.getName());
        return generoConverter.toGeneroBaseDto(generoEntity);
    }

    public List<GeneroDto> getAllGenero(){
        List<Genero> genero = generoRepository.findAll();
         List<GeneroDto> generoDtos = genero.stream().map(genero1 -> generoConverter.toGeneroDto(genero1)).collect(Collectors.toList());
         return generoDtos;
    }
}
