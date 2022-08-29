package com.santiago.AppDisney.repository;

import com.santiago.AppDisney.domain.Characters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Characters,Long> {

    @Query("SELECT n FROM Characters n WHERE " +
            "n.name LIKE CONCAT('%',:name, '%')")
    Page<Characters> findByName(String name, Pageable pageable);



    @Query("SELECT * FROM Characters WHERE Characters.name=:name")
    List<Characters>  findByName(String name);
}
