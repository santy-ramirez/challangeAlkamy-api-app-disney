package com.santiago.AppDisney.dto.genero;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class GeneroBaseDto {

    private Long id;
    @NotBlank
    private String name;

    public GeneroBaseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
