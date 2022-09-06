package com.santiago.AppDisney.service;

import com.santiago.AppDisney.converter.GeneroConverter;
import com.santiago.AppDisney.domain.Genero;
import com.santiago.AppDisney.dto.genero.GeneroBaseDto;
import com.santiago.AppDisney.repository.GeneroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GeneroServiceTest {

    @Mock
    private GeneroRepository generoRepository;
    @Mock
    private GeneroConverter generoConverter;
    @InjectMocks
    private GeneroService generoService;



    @Test
    void when_call_method_updateupdateGenero_return_objet_updated() {

        Genero genero = new Genero();
        genero.setId(1l);
        genero.setName("action");
        GeneroBaseDto generoBaseDto = new GeneroBaseDto();
        generoBaseDto.setName("action update");

        when(generoRepository.findById(1l)).thenReturn(Optional.of(genero));
        when(generoService.updateGenero(1l,generoConverter.toGeneroDto(genero))).thenReturn(generoBaseDto);

        GeneroBaseDto generoTest = generoService.updateGenero(1l,generoConverter.toGeneroDto(genero));

        assertEquals(generoTest.getName(),generoBaseDto.getName());
        assertNotEquals(genero.getName(),generoTest.getName());


    }



}