package com.alkemy.disney.controller;

import com.alkemy.disney.entity.Personaje;
import com.alkemy.disney.services.PersonajeService;
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
@RequestMapping("/characters")
public class PersonajeController {
    
    @Autowired
    private PersonajeService ps;
    
    @GetMapping()
    public List<Personaje> listarPersonajes(@RequestParam(required = false) String name, 
                                            @RequestParam(required = false) Integer age, 
                                            @RequestParam(required = false) Integer movies ){
        if(name != null){
            return ps.findByName(name);
        }else if(age !=null){
            return ps.findByAge(age);
        }else if(movies != null){
            return ps.findByFilm(movies);
        }else{
            return ps.listAll();
        }
        
    }
    
    @PostMapping()
    public Personaje guardarPersonaje(@RequestBody Personaje character,
                                      @RequestParam(required = false) MultipartFile image){
        return ps.crearPersonaje(character, image);
    }
       
    @GetMapping("/delete")
    public Boolean eliminarPersonaje(@RequestParam(required = true) Integer character_id){
        return ps.eliminarPersonaje(character_id);
    }
    
}
