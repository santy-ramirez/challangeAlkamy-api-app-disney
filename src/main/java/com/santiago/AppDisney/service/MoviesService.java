package com.santiago.AppDisney.service;

import com.santiago.AppDisney.converter.MoviesConverter;
import com.santiago.AppDisney.domain.Movies;
import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.movies.MoviesBaseDto;
import com.santiago.AppDisney.dto.movies.MoviesDto;
import com.santiago.AppDisney.repository.MoviesRepository;
import com.santiago.AppDisney.repository.PersonageRepository;
import com.santiago.AppDisney.util.CustumerPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MoviesService {
    private MoviesRepository moviesRepository;
    private PersonageRepository personageRepository;
    private MoviesConverter moviesConverter;

    @Autowired

    public MoviesService(MoviesRepository moviesRepository,
                         MoviesConverter moviesConverter,
                         PersonageRepository personageRepository
    ) {
        this.moviesRepository = moviesRepository;
        this.moviesConverter = moviesConverter;
        this.personageRepository = personageRepository;
    }

    public MoviesBaseDto createMovie(MoviesBaseDto movie){
      Movies movieSave = moviesConverter.toMovieEntity(movie);
     Movies movies = moviesRepository.save(movieSave);
      return moviesConverter.toMovieBaseDto(movies);
    }

    public CustumerPage getAllMovie(){
        Pageable pageable = PageRequest.of(0,3);
        Page<Movies> movies = moviesRepository.findAll(pageable);
        CustumerPage custumerPage = new CustumerPage();
        custumerPage.setContent(movies.getContent().stream().map(movies1 -> moviesConverter.toMovieBaseDto(movies1)).collect(Collectors.toList()));
        return custumerPage;
    }

    public MoviesDto getList(Long idMovie, Long idPersonage) throws  RuntimeException{
        if(! moviesRepository.existsById(idMovie)){
            throw new RuntimeException("no se encontro con este articulo");
        }
     if (! personageRepository.existsById(idPersonage)){
         throw new RuntimeException("no se encontro personage");
     }
       Movies movies= moviesRepository.findById(idMovie).orElseThrow(
               ()->new RuntimeException("no se encontro peliculas")
       );
       Personage personage = personageRepository.findById(idPersonage).orElseThrow(
               ()-> new RuntimeException("no se encontro personages")
       );
       Movies movies1 = new Movies();

       movies.addPersonage(personage);
       moviesRepository.save(movies);
       return moviesConverter.toMoviesDto(movies);
    }

    public MoviesDto deletePersonage(Long idMovie, Long idPersonage){
        if(! moviesRepository.existsById(idMovie)){
            throw new RuntimeException("no se encontro con este articulo");
        }
        if (! personageRepository.existsById(idPersonage)){
            throw new RuntimeException("no se encontro personage");
        }
        Movies movies= moviesRepository.findById(idMovie).orElseThrow(
                ()->new RuntimeException("no se encontro peliculas")
        );
        Personage personage = personageRepository.findById(idPersonage).orElseThrow(
                ()-> new RuntimeException("no se encontro personages")
        );
        movies.remove(idPersonage);
        return moviesConverter.toMoviesDto(movies);
    }
}
