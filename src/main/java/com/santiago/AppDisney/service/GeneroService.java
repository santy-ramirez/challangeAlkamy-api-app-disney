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

    public GeneroBaseDto createGenero(GeneroBaseDto genero){
      Genero genero1 =  generoConverter.toTestGeneroEntity(genero);
        generoRepository.save(genero1);
        return generoConverter.toTestGeneroDto(genero1);
    }

    public GeneroBaseDto updateGenero(Long id,GeneroBaseDto generoBaseDto){
        Genero generoEntity = generoRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Not found genero ")
        );
        generoEntity.setId(id);
        generoEntity.setName(generoBaseDto.getName());
        generoRepository.save(generoEntity);
        return generoConverter.toTestGeneroDto(generoEntity);
    }

    public List<GeneroDto> getAllGenero(){
        List<Genero> genero = generoRepository.findAll();
         List<GeneroDto> generoDtos = genero.stream().map(generoConverter::toTestCompleteGeneroDto).collect(Collectors.toList());
         return generoDtos;
    }
}
