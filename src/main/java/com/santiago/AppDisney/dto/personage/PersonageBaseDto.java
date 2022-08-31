package com.santiago.AppDisney.dto.personage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonageBaseDto {

    private String name;
    private String image;

    public PersonageBaseDto( String name,String image) {

        this.name = name;
        this.image = image;
    }
}
