package com.santiago.AppDisney.converter;


import com.santiago.AppDisney.domain.Characters;
import com.santiago.AppDisney.dto.characters.CharacterBaseDto;
import com.santiago.AppDisney.dto.characters.CharacterDto;
import org.springframework.stereotype.Component;


@Component
public class CharacterConverter {
    public CharacterBaseDto toDtoBase(Characters characters){
        return new CharacterBaseDto(characters.getId_character(),characters.getName());

    }




public Characters toEntityBase(CharacterBaseDto characterBaseDto){
        return new Characters(
                characterBaseDto.getId_character(),
                characterBaseDto.getName()
        );
}
}
