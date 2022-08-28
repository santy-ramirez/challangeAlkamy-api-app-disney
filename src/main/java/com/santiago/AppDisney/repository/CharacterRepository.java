package com.santiago.AppDisney.repository;

import com.santiago.AppDisney.domain.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Characters,Long> {

}
