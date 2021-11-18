package com.alkemy.disney.services;

import com.alkemy.disney.entity.Film;
import com.alkemy.disney.repository.FilmRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class FilmService {
    
    @Autowired
    private FilmRepository fr;
    
    @Transactional
    public Film crearFilm(Film f){
        return fr.save(f);
    }
    
    @Transactional
    public void modificarFilm(Film f){
        Film film = fr.findById(f.getFilm_id()).get();
        if(film != null){
            film = f;
            crearFilm(film);
        }         
    }
    
    public List<Film> listAll(){
        return (List<Film>) fr.findAll();
    }
    
    public Optional<Film> findById(Integer id){
        return fr.findById(id);
    }
    
    public List<Film> findByTitle(String title){
        return fr.findByTitle("%" + title + "%");
    }
    
    @Transactional
    public Boolean eliminarFilm(Integer film_id){
        Film f = fr.findById(film_id).get();
        try{
            fr.delete(f);
            return true;
        } catch(Exception e){
            return false;
        }
        
    }

    public List<Film> findByName(String name) {
        return fr.findByName("%" + name + "%");
    }

    public List<Film> findByGenero(Integer genre) {
        return fr.findByGenero(genre);
    }

    public List<Film> order(String order) {
        try{
            order = order.toUpperCase();
            return fr.orderBy(order);
        }catch (Exception e){
            return listAll();
        }
    }
    
}
