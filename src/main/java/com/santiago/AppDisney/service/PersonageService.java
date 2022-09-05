package com.santiago.AppDisney.service;

import com.santiago.AppDisney.converter.PersonageConverter;
import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.personage.PersonageQueryDto;
import com.santiago.AppDisney.util.BuildPage;
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
    public PersonageQueryDto createCharacter(PersonageQueryDto personageQueryDto){
        Personage personageEntity = personageConverter.toPersonageQueryEntity(personageQueryDto);
        Personage personage = personageRepository.save(personageEntity);
        PersonageQueryDto personageDto = personageConverter.toPersonageQueryDto(personage);
        return personageDto;
    }

    public PersonageQueryDto updatePersonage(Long id,PersonageQueryDto personage){
        Personage personageEntity = personageRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("not found personage")
        );
        personageEntity.setId(id);
        personageEntity.setName(personage.getName());
        personageEntity.setPeso(personage.getPeso());
        personageEntity.setImage(personage.getImage());
        personageEntity.setAge(personage.getAge());
        personageRepository.save(personageEntity);
        return personageConverter.toPersonageQueryDto(personageEntity);
    }

    public String deletePersonage(Long id){
        personageRepository.deleteById(id);
        return "delete correct personage with number"+ id;
    }

    //update characters
    public CustumerPage getAllPersonages(int page, String name,Integer age){
        Pageable pageable = PageRequest.of(page-1,3) ;
        BuildPage buildPage = new BuildPage();
        Boolean notIsNull = notIqualNull(age,name);
        if(notIsNull){
            Page<Personage> personageFilter = personageRepository.findAllByNameOrAge(name,age,pageable);
            buildPage.paginate(personageFilter).content(personageFilter.getContent().stream().
                            map(personageConverter::toDtoBase).
                            collect(Collectors.toList()));

        } else {
            Page<Personage> personages = personageRepository.findAll(pageable);
            buildPage.paginate(personages).content(personages.getContent().stream().
                            map(personageConverter::toDto).
                            collect(Collectors.toList()));


    }
        return buildPage.build();
    }

    private Boolean notIqualNull(Integer age,String name){
        if(age!=null){
            return true;}
        if (name != null){
            return true;}
        return false;
    }


}

