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
    Page<Personage> findAllByNameOrAge(String name,Integer age,Pageable pageable);
}
