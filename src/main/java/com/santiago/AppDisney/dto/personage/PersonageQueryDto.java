package com.santiago.AppDisney.dto.personage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonageQueryDto extends PersonageBaseDto{
    private Integer age;
    private Long peso;
    private String history;



    public PersonageQueryDto( String name, String image, Integer age, Long peso, String history) {
        super( name, image);
        this.age = age;
        this.peso = peso;
        this.history = history;
    }
}
