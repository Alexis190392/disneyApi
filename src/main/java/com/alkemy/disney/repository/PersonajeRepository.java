package com.alkemy.disney.repository;

import com.alkemy.disney.entity.Personaje;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Integer>{
    
    @Query("SELECT p FROM Personaje p where p.nombre like :name")
    List<Personaje> findByName(@Param("name") String name);

    @Query("SELECT p FROM Personaje p where p.edad = :age")
    List<Personaje> findByAge(@Param("age") Integer age);
    
    @Query("SELECT p from Personaje p where film.film_id = :movie_id")
    List<Personaje> findByMovie(@Param("movie_id") Integer movie_id);
}
