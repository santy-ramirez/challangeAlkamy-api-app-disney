package com.santiago.AppDisney.service;

import com.santiago.AppDisney.converter.PersonageConverter;
import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.personage.PersonageBaseDto;
import com.santiago.AppDisney.dto.personage.PersonageDto;
import com.santiago.AppDisney.util.BuildPage;
import com.santiago.AppDisney.util.CustumerPage;
import com.santiago.AppDisney.repository.PersonageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

    public PersonageBaseDto updatePersonage(Long id,PersonageBaseDto personageBaseDto){
        Personage personage = personageConverter.toEntityBase(personageBaseDto);
        Personage personage1 = personageRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("not find personage")
        );
        personage1.setId(id);
        personage1.setName(personage.getName());
        personageRepository.save(personage1);
        return personageConverter.toDtoBase(personage1);
    }

    public String deletePersonage(Long id){
        personageRepository.deleteById(id);
        return "delete correct personage with";
    }

    //update characters
    public CustumerPage getAllCharacter(int page, String prefix){
        Pageable pageable = PageRequest.of(page,3) ;
        BuildPage buildPage = new BuildPage();

        if(prefix != null){
            Page<Personage> charactersPage = personageRepository.findByName(prefix,pageable);
            buildPage.
                    status(HttpStatus.OK).
                    page(charactersPage.getTotalPages()).
                    size(charactersPage.getSize()).
                    totalResult(charactersPage.getTotalElements()).
                    content(charactersPage.getContent().
                            stream().
                            map(personageConverter::toDtoBase).
                            collect(Collectors.toList()));

        } else {
            Page<Personage> charactersPage = personageRepository.findAll(pageable);
            buildPage.
                    page(charactersPage.getTotalPages()).
                    size(charactersPage.getSize()).
                    totalResult(charactersPage.getTotalElements()).
                    content(charactersPage.getContent().
                            stream().
                            map(personageConverter::toDto).
                            collect(Collectors.toList()));


    }

        return buildPage.build();
    }

    public CustumerPage getAllPersonageDetail(int page){
        Pageable pageable = PageRequest.of(page,3);
      Page<Personage> personage=  personageRepository.findAll(pageable);
        BuildPage buildPage = new BuildPage();
        buildPage.
                status(HttpStatus.OK).
                page(personage.getTotalPages()).
                totalResult(personage.getTotalElements()).
                size(personage.getSize()).
                content(personage.getContent().
                        stream().
                        map(personageConverter::toDto).
                        collect(Collectors.toList()));
        return buildPage.build();
    }


}

