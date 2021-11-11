package com.alkemy.disney.controller;

import com.alkemy.disney.entity.Personaje;
import com.alkemy.disney.services.PersonajeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class PersonajeController {
    
    @Autowired
    private PersonajeService ps;
    
    @GetMapping()
    public List<Personaje> listarPersonajes(){
        return ps.listAll();
    }
    
    @PostMapping()
    public Personaje guardarPersonaje(@RequestBody Personaje personaje){
        System.out.println("\nValores Controller:\n"
                + personaje.getNombre() + "\n"
                + personaje.getEdad() + "\n"
                + personaje.getPeso() + "\n"
                + personaje.getHistoria() + "\n"
                + "\n");
        return ps.crearPersonaje(personaje);
    }
    
    
}
