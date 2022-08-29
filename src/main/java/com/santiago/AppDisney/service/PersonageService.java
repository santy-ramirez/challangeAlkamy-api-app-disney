package com.santiago.AppDisney.service;

import com.santiago.AppDisney.converter.PersonageConverter;
import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.characters.PersonageBaseDto;
import com.santiago.AppDisney.dto.characters.PersonagePage;
import com.santiago.AppDisney.repository.PersonageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonageService {
    private final PersonageRepository personageRepository;
    private final PersonageConverter personageConverter;
    @Autowired
    public PersonageService(PersonageRepository characterRepository,
                            PersonageConverter characterConverter) {
        this.personageRepository = characterRepository;
        this.personageConverter = characterConverter;
    }

    //create characters
    public PersonageBaseDto createCharacter(PersonageBaseDto characterBaseDto){
        Personage characters = personageConverter.toEntityBase(characterBaseDto);
        Personage characters1 = personageRepository.save(characters);
        return personageConverter.toDtoBase(characters1);
    }

    //update characters
    public PersonagePage getAllCharacter(int page, String prefix){
        Pageable pageable = PageRequest.of(page,3) ;
        PersonagePage characterPageCustum = new PersonagePage();
    if(prefix != null){
            Page<Personage> charactersPage = personageRepository.findByName(prefix,pageable);

            characterPageCustum.setContent(charactersPage.getContent().stream().map(characters -> personageConverter.toDtoBase2(characters)).collect(Collectors.toList()));
        }else {
            Page<Personage> charactersPage = personageRepository.findAll(pageable);
            characterPageCustum.setContent(charactersPage.getContent().stream().map(characters -> personageConverter.toDtoBase(characters)).collect(Collectors.toList()));


    }
        return characterPageCustum;
    }


}

