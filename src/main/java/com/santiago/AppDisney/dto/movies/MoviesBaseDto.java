package com.santiago.AppDisney.dto.movies;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MoviesBaseDto {
    @JsonIgnore
    private Long Id;
    @NotBlank
    private String title;
    @NotBlank
    @URL
    private String image;

    private LocalDate createAt=LocalDate.now();

    public MoviesBaseDto(Long id, String title,String image,LocalDate createAt) {
        Id = id;
        this.title = title;
        this.image = image;
        this.createAt = createAt;

    }
}
