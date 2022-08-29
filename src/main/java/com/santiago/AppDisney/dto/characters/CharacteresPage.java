package com.santiago.AppDisney.dto.characters;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class CharacteresPage {
    private HttpStatus status;
    private int page;
    private int size;
    private Long totalResult;
    private List<?> content = new ArrayList<>();
}
