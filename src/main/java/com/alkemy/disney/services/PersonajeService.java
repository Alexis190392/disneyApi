package com.alkemy.disney.services;

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
    
    
    @Transactional
    public void eliminarPersonaje(Personaje p){
        pr.delete(p);
    }
    
}
