package com.santiago.AppDisney.dto.characters;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CharacterBaseDto {
    private Long Id_character;
    private String name;

    public CharacterBaseDto(Long id_character, String name) {
        Id_character = id_character;
        this.name = name;
    }
}
