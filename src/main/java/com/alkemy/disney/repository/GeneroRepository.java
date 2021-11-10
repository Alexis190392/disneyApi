package com.alkemy.disney.repository;

import com.alkemy.disney.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository  extends JpaRepository<Genero, String>{
    
}
