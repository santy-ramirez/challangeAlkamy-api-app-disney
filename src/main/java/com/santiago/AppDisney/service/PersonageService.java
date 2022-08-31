package com.santiago.AppDisney.service;

import com.santiago.AppDisney.converter.PersonageConverter;
import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.personage.PersonageBaseDto;
import com.santiago.AppDisney.dto.personage.PersonageDto;
import com.santiago.AppDisney.dto.personage.PersonageQueryDto;
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
    public PersonageQueryDto createCharacter(PersonageQueryDto personageQueryDto){
       Personage personage = personageConverter.toPersonageQueryEntity(personageQueryDto);
        Personage characters1 = personageRepository.save(personage);
        PersonageQueryDto personageDto = personageConverter.toPersonageQueryDto(characters1);
        return personageDto;
    }

    public PersonageQueryDto updatePersonage(Long id,PersonageQueryDto personage){
        Personage personage1 = personageRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("not found personage")
        );
        personage1.setId(id);
        personage1.setName(personage.getName());
        personage1.setPeso(personage.getPeso());
        personage1.setImage(personage.getImage());
        personage1.setAge(personage.getAge());
        personageRepository.save(personage1);
        return personageConverter.toPersonageQueryDto(personage1);
    }

    public String deletePersonage(Long id){
        personageRepository.deleteById(id);
        return "delete correct personage with number"+ id;
    }

    //update characters
    public CustumerPage getAllPersonages(int page, String name,Integer age){
        Pageable pageable = PageRequest.of(page,3) ;
        BuildPage buildPage = new BuildPage();
       Boolean notIsNull = notIqualNull(age,name);
        if(notIsNull){
            Page<Personage> charactersPage = personageRepository.findAllByNameOrAge(name,age,pageable);
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

    private Boolean notIqualNull(Integer age,String name){
        if(age!=null){
            return true;
        }
        if (name != null){
            return true;
        }
            return false;
 }


}

