package com.santiago.AppDisney.service;

import com.santiago.AppDisney.converter.MoviesConverter;
import com.santiago.AppDisney.domain.Movies;
import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.movies.MoviesBaseDto;
import com.santiago.AppDisney.dto.movies.MoviesDto;
import com.santiago.AppDisney.dto.movies.MoviesQueryDto;
import com.santiago.AppDisney.repository.MoviesRepository;
import com.santiago.AppDisney.repository.PersonageRepository;
import com.santiago.AppDisney.util.BuildPage;
import com.santiago.AppDisney.util.CustumerPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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

    public MoviesQueryDto createMovie(MoviesQueryDto movie){
     Movies movies = moviesConverter.toMovieQueryEntity(movie);
    Movies moviesSaved = moviesRepository.save(movies);

      return moviesConverter.toMoviesQueryDto(movies);
    }

    public CustumerPage getAllMovie(String query){
        Pageable pageable = PageRequest.of(0,3, Sort.by("title").descending());

        BuildPage buildPage = new BuildPage();
        if (query != null){
            Page<Movies> movies1 = moviesRepository.findByName(query,pageable);
            buildPage.
                    status(HttpStatus.OK).
                    page(movies1.getTotalPages()).
                    totalResult(movies1.getTotalElements()).
                    size(movies1.getSize()).
                    content( movies1.getContent().
                            stream().map(movies2 -> moviesConverter.
                            toMovieBaseDto(movies2)).
                            collect(Collectors.toList()));
        }else{
            Page<Movies> movies = moviesRepository.findAll(pageable);
            buildPage.
                    status(HttpStatus.OK).
                    page(movies.getTotalPages()).
                    totalResult(movies.getTotalElements()).
                    size(movies.getSize()).
                            content(movies.getContent().
                            stream().map(movies1 -> moviesConverter.
                            toMoviesDto(movies1)).
                            collect(Collectors.toList()));
        }

        return buildPage.build();
    }

    public MoviesDto getList(Long idMovie, Long idPersonage) throws  RuntimeException{
        if(! moviesRepository.existsById(idMovie)){
            throw new RuntimeException("Not Found movies with number:" + idMovie);
        }
     if (! personageRepository.existsById(idPersonage)){
         throw new RuntimeException("Not Found personage with number id" + idPersonage);
     }
       Movies movies= moviesRepository.findById(idMovie).orElseThrow(
               ()->new RuntimeException("Not Found movies with number:" + idMovie)
       );
       Personage personage = personageRepository.findById(idPersonage).orElseThrow(
               ()-> new RuntimeException("Not Found personage with number id" + idPersonage)
       );


       movies.addPersonage(personage);
       moviesRepository.save(movies);
       return moviesConverter.toMoviesDto(movies);
    }

    public MoviesDto deletePersonage(Long idMovie, Long idPersonage){
        if(! moviesRepository.existsById(idMovie)){
            throw new RuntimeException("Not Found movies with number:" + idMovie);
        }
        if (! personageRepository.existsById(idPersonage)){
            throw new RuntimeException("Not Found personage with number id" + idPersonage);
        }
        Movies movies= moviesRepository.findById(idMovie).orElseThrow(
                ()->new RuntimeException("Not Found movies with number:" + idMovie)
        );
        Personage personage = personageRepository.findById(idPersonage).orElseThrow(
                ()-> new RuntimeException("Not Found personage with number id" + idPersonage)
        );
        movies.remove(idPersonage);
        return moviesConverter.toMoviesDto(movies);
    }
}
