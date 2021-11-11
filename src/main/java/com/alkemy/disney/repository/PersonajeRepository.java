package com.alkemy.disney.repository;

import com.alkemy.disney.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends CrudRepository<Personaje, Integer>{
    
}
