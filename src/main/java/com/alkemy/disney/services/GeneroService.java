package com.alkemy.disney.services;

import com.alkemy.disney.entity.Genero;
import com.alkemy.disney.entity.Imagen;
import com.alkemy.disney.repository.GeneroRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GeneroService {
    
    @Autowired
    private GeneroRepository gr;
    @Autowired
    private ImagenService imgs;
    
    @Transactional
    public Genero crearGenero(Genero g, MultipartFile image){
        Imagen i = imgs.save(image);
        g.setImagen(i);
        return gr.save(g);
    }
    
    @Transactional
    public void modificarGenero(Genero g, MultipartFile image){
        Genero genero = gr.findById(g.getGenero_id()).get();
        if(genero != null){
            genero = g;
            crearGenero(genero,image);
        }         
    }
    
    public List<Genero> listAll(){
        return (List<Genero>) gr.findAll();
    }
    
    public Optional<Genero> findById(Integer id){
        return gr.findById(id);
    }
    
    public List<Genero> findByName(String name){
        return gr.findByName("%" + name + "%");
    }    
    
    @Transactional
    public Boolean eliminarGenero(Genero g){
        try{
            gr.delete(g);
            return true;
        } catch(Exception e){
            return false;
        }
        
    }

    public Boolean eliminarGenero(Integer gender_id) {
        Genero g = gr.findById(gender_id).get();
        try{
            imgs.delete(g.getImagen());
            g.setImagen(null);
            gr.delete(g);
            return true;
        } catch(Exception e){
            return false;
        }   
        
    }

    
}
