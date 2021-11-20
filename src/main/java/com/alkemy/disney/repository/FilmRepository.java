package com.alkemy.disney.repository;

import com.alkemy.disney.entity.Film;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>{
    @Query("SELECT f FROM Film f where f.titulo like :title")
    List<Film> findByTitle(@Param("title") String title);

    @Query("SELECT f from Film f where genero.genero_id = :genre")
    List<Film> findByGenero(@Param("genre") Integer genre);

    @Query("SELECT f from Film f order by :order")
    List<Film> orderBy(@Param("order") String order);
}
