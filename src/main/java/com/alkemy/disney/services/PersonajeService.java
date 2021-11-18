package com.alkemy.disney.services;

import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Personaje;
import com.alkemy.disney.repository.PersonajeRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeService {
    
    @Autowired
    private PersonajeRepository pr;
    
    @Transactional
    public Personaje crearPersonaje(Personaje p){
//        System.out.println("\nValores Servicio:\n"
//                + p.getNombre() + "\n"
//                + p.getEdad() + "\n"
//                + p.getPeso() + "\n"
//                + p.getHistoria() + "\n"
//                + "\n");
        return pr.save(p);
    }
    
    @Transactional
    public void modificarPersonaje(Personaje p){
        Personaje personaje = pr.findById(p.getPersonaje_id()).get();
        if(personaje != null){
            personaje = p;
            crearPersonaje(personaje);
        }         
    }
    
    public List<Personaje> listAll(){
        return (List<Personaje>) pr.findAll();
    }
    
    public Optional<Personaje> findById(Integer id){
        return pr.findById(id);
    }
    
    public List<Personaje> findByName(String name){
        return pr.findByName("%" + name + "%");
    }    
    
    public List<Personaje> findByAge(Integer age){
        return pr.findByAge(age);
    }
    
    public List<Personaje> findByFilm(Integer movie_id){
        return pr.findByMovie(movie_id);
        
    }
    
    
    @Transactional
    public Boolean eliminarPersonaje(Personaje p){
        try{
            pr.delete(p);
            return true;
        } catch(Exception e){
            return false;
        }
        
    }
    
}
