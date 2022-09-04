package com.santiago.AppDisney.dto.personage;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class PersonageBaseDto {

    @NotBlank
    private String name;
    @NotBlank
    @URL
    private String image;

    public PersonageBaseDto( String name,String image) {

        this.name = name;
        this.image = image;
    }
}
