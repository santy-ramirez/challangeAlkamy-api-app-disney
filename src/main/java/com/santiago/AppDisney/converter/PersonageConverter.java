package com.santiago.AppDisney.converter;


import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.characters.PersonageBaseDto;
import com.santiago.AppDisney.dto.characters.PersonageDto;
import org.springframework.stereotype.Component;


@Component
public class PersonageConverter {
    public PersonageBaseDto toDtoBase(Personage characters){
        return new PersonageBaseDto(characters.getId());

    }

    public PersonageDto toDtoBase2(Personage characters){
        return new PersonageDto(characters.getId(),characters.getName());

    }



public Personage toEntityBase(PersonageBaseDto characterBaseDto){
        return new Personage(
                characterBaseDto.getId()

        );
}
}
