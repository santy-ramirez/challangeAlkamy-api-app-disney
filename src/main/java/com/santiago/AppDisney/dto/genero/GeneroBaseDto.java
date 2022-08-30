package com.santiago.AppDisney.dto.genero;

import lombok.Data;

@Data
public class GeneroBaseDto {
    private Long id;
    private String name;

    public GeneroBaseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
