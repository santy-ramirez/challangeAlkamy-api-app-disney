package com.santiago.AppDisney.dto.genero;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeneroBaseDto {
    private Long id;
    private String name;

    public GeneroBaseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
