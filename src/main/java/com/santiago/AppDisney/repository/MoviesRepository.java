package com.santiago.AppDisney.repository;

import com.santiago.AppDisney.domain.Movies;
import com.santiago.AppDisney.domain.Personage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movies,Long> {


    @Query("SELECT n FROM Movies n WHERE " +
            "n.title LIKE CONCAT('%',:query, '%')")
    Page<Movies> findByName(String query, Pageable pageable);
}
