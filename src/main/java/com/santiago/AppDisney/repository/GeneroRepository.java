package com.santiago.AppDisney.repository;

import com.santiago.AppDisney.domain.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero,Long> {

}
