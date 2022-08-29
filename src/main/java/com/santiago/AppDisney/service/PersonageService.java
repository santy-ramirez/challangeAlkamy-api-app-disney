package com.santiago.AppDisney.service;

import com.santiago.AppDisney.converter.PersonageConverter;
import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.personage.PersonageBaseDto;
import com.santiago.AppDisney.util.CustumerPage;
import com.santiago.AppDisney.repository.PersonageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public CustumerPage getAllCharacter(int page, String prefix){
        Pageable pageable = PageRequest.of(page,3) ;
        CustumerPage characterPageCustum = new CustumerPage();
    if(prefix != null){
            Page<Personage> charactersPage = personageRepository.findByName(prefix,pageable);

            characterPageCustum.setContent(charactersPage.getContent().stream().map(characters -> personageConverter.toDtoBase(characters)).collect(Collectors.toList()));
        }else {
            Page<Personage> charactersPage = personageRepository.findAll(pageable);
            characterPageCustum.setContent(charactersPage.getContent().stream().map(characters -> personageConverter.toDto(characters)).collect(Collectors.toList()));


    }
        return characterPageCustum;
    }


}

