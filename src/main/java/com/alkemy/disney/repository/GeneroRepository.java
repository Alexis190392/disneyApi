package com.alkemy.disney.repository;

import com.alkemy.disney.entity.Genero;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GeneroRepository  extends JpaRepository<Genero, Integer>{
    @Query("SELECT g FROM Genero g where g.nombre like :name")
    List<Genero> findByName(@Param("name") String name);
}
