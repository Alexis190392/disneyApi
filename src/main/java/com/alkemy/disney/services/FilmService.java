package com.alkemy.disney.services;

import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Imagen;
import com.alkemy.disney.repository.FilmRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilmService {
    
    @Autowired
    private FilmRepository fr;
    @Autowired
    private ImagenService imgs;
    
    @Transactional
    public Film crearFilm(Film f, MultipartFile imagen) throws Exception{
        Film film = new Film();
        if(validadPuntos(f.getCalificacion())){
            film.setCalificacion(f.getCalificacion());
        } else{
            throw new Exception("Puntuacion no corresponde.");
        }
        if(f.getTitulo() == null){
            throw new Exception("Ingrese un titulo válido");
        }      
        
        film.setTitulo(f.getTitulo());
        film.setFecha_creacion(f.getFecha_creacion());
        film.setGenero(f.getGenero());        
        
        Imagen i = imgs.save(imagen);
        f.setImagen(i);
        return fr.save(film);
    }
    
    
    @Transactional
    public void modificarFilm(Film f, MultipartFile imagen) throws Exception{
        Film film = fr.findById(f.getFilm_id()).get();
        if(film != null){
            film = f;
            crearFilm(film,imagen);
        }         
    }
    
    public List<Film> listAll(){
        return (List<Film>)fr.findAll();
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
            imgs.delete(f.getImagen());
            f.setImagen(null);
            fr.delete(f);
            return true;
        } catch(Exception e){
            return false;
        }
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
    
    public Boolean validadPuntos(Integer puntos){
        if(puntos <= 5 && puntos >0){
            return true;
        } else{
            return false;
        }
    }
    
}
