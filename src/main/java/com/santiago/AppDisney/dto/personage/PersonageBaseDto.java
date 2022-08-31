package com.santiago.AppDisney.dto.personage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonageBaseDto {
    private Long Id;
    private String name;
    private String image;

    public PersonageBaseDto(Long id, String name,String image) {
        Id = id;
        this.name = name;
        this.image = image;
    }
}
