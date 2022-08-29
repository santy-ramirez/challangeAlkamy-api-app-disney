package com.santiago.AppDisney.service;

import com.santiago.AppDisney.converter.CharacterConverter;
import com.santiago.AppDisney.domain.Characters;
import com.santiago.AppDisney.dto.characters.CharacterBaseDto;
import com.santiago.AppDisney.dto.characters.CharacterDto;
import com.santiago.AppDisney.dto.characters.CharacteresPage;
import com.santiago.AppDisney.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;
    private final CharacterConverter characterConverter;
    @Autowired
    public CharacterService(CharacterRepository characterRepository,
                            CharacterConverter characterConverter) {
        this.characterRepository = characterRepository;
        this.characterConverter = characterConverter;
    }

    //create characters
    public CharacterBaseDto createCharacter(CharacterBaseDto characterBaseDto){
        Characters characters = characterConverter.toEntityBase(characterBaseDto);
        Characters characters1 = characterRepository.save(characters);
        return characterConverter.toDtoBase(characters1);
    }

    //update characters
    public CharacteresPage getAllCharacter(int page, String prefix){
        Pageable pageable = PageRequest.of(page,3) ;
        CharacteresPage characterPageCustum = new CharacteresPage();
//     if(prefix != null){
            Page<Characters> charactersPage = characterRepository.findByName(prefix,pageable);

            characterPageCustum.setContent(charactersPage.getContent().stream().map(characters -> characterConverter.toDtoBase(characters)).collect(Collectors.toList()));
      /*  }else {
            Page<Characters> charactersPage = characterRepository.findAll(pageable);
            characterPageCustum.setContent(charactersPage.getContent().stream().map(characters -> characterConverter.toDtoBase(characters)).collect(Collectors.toList()));


    }*/
        return characterPageCustum;
    }
    public Page getForName(int page, String name){
        Pageable pageable = PageRequest.of(page,3) ;


        Page<Characters> charactersPage = characterRepository.findByName(name,pageable);

        charactersPage.getContent().stream().map(characters -> characterConverter.toDtoBase(characters)).collect(Collectors.toList());

        return charactersPage;
    }

    public List<CharacterBaseDto> getlistname(String name){
        List<Characters> characters = characterRepository.findByName(name);
        List<CharacterBaseDto> characterBaseDtoList = characters.stream().map(characters1 -> characterConverter.toDtoBase(characters1)).collect(Collectors.toList());
    return characterBaseDtoList;
    }

}

