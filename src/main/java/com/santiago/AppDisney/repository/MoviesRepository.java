package com.santiago.AppDisney.repository;

import com.santiago.AppDisney.domain.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movies,Long> {
}
