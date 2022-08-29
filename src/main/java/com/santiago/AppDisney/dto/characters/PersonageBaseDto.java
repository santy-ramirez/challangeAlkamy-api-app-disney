package com.santiago.AppDisney.dto.characters;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonageBaseDto {
    private Long Id;



    public PersonageBaseDto(Long id) {
        this.Id = id;

    }
}
