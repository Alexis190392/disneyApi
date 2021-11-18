package com.alkemy.disney.controller;

import com.alkemy.disney.entity.Film;
import com.alkemy.disney.services.FilmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/movies")
public class FilmController {
    
    @Autowired
    private FilmService fs;
    
    @GetMapping()
    public List<Film> listarFilms(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) Integer genre,
                                  @RequestParam(required = false) String order){
        
        if(name != null){
            return fs.findByName(name);
        } 
        if(genre !=null){
            return fs.findByGenero(genre);
        }
        if(order != null){
            return fs.order(order);
        }else{
            return fs.listAll();
        }
    }
    
    @PostMapping()
    public Film guardarFilm(@RequestBody Film film,
                            @RequestParam(required = false) MultipartFile image){
        return fs.crearFilm(film,image);
    }
    
    @GetMapping("/delete")
    public Boolean eliminarPersonaje(@RequestParam Integer film_id){
        return fs.eliminarFilm(film_id);
    }
    
}
