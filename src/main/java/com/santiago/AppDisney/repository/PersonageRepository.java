package com.santiago.AppDisney.repository;

import com.santiago.AppDisney.domain.Personage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonageRepository extends JpaRepository<Personage,Long> {
/*
    @Query("SELECT n FROM Personage n WHERE " +
            "n.name LIKE CONCAT('%',:query, '%')")*/
@Query("SELECT n FROM Personage n WHERE " +
        "n.name LIKE CONCAT('%',:name, '%')")
    Page<Personage> findByName(String name, Pageable pageable);
    Page<Personage> findAllByAge(Integer age,Pageable pageable);
}
