package com.santiago.AppDisney.dto.personage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonageBaseDto {
    private Long Id;
    private String name;


    public PersonageBaseDto(Long id, String name) {
        Id = id;
        this.name = name;
    }
}
