package com.alkemy.disney.services;

import com.alkemy.disney.entity.Imagen;
import com.alkemy.disney.entity.Personaje;
import com.alkemy.disney.repository.PersonajeRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PersonajeService {
    
    @Autowired
    private PersonajeRepository pr;
    @Autowired
    private ImagenService imgs;
    
    @Transactional
    public Personaje crearPersonaje(Personaje p, MultipartFile imagen) throws Exception{
        Personaje per = new Personaje();
        
        
        if(p.getEdad() == null && p.getEdad()<=0){
            throw new Exception("Edad no válida.");
        }
        if(p.getNombre() == null){
            throw new Exception("Ingresar nombre válido");
        }
        if(p.getPeso() <= 0d){
            throw new Exception("Peso no permitido");
        }
        
        per.setNombre(p.getNombre());
        per.setEdad(p.getEdad());
        per.setPeso(p.getPeso());
        per.setFilm(p.getFilm());
        per.setHistoria(p.getHistoria());
        
        Imagen i = imgs.save(imagen);
        per.setImagen(i);
        return pr.save(per);
    }
    
    @Transactional
    public void modificarPersonaje(Personaje p, MultipartFile imagen) throws Exception{
        Personaje personaje = pr.findById(p.getPersonaje_id()).get();
        if(personaje != null){
            personaje = p;
            crearPersonaje(personaje,imagen);
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
    public void eliminarPersonaje(Integer id) throws Exception{            
        
        try {
            pr.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
