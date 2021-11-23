package com.alkemy.disney.controller;

import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Genero;
import com.alkemy.disney.entity.Personaje;
import com.alkemy.disney.services.FilmService;
import com.alkemy.disney.services.GeneroService;
import com.alkemy.disney.services.PersonajeService;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/img")
public class ImagenController {

    @Autowired
    private PersonajeService ps;
    @Autowired
    private FilmService fs;
    @Autowired
    private GeneroService gs;
            
            
            
            
    @GetMapping("/character")
    public ResponseEntity<byte[]> imagenPersonaje(@RequestParam(required = true) Integer id) {

        try {
            Personaje p = ps.findById(id).get();
            if (p.getImagen() == null) {
                throw new Exception("El personaje no tiene una imagen asignada.");
            }
            byte[] imagen = p.getImagen().getContenido();
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(imagen, hh, HttpStatus.OK);

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ImagenController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/movies")
    public ResponseEntity<byte[]> imagenMovies(@RequestParam(required = true) Integer id) {

        try {
            Film f = fs.findById(id).get();
            if (f.getImagen() == null) {
                throw new Exception("El Film no tiene una imagen asignada.");
            }
            byte[] imagen = f.getImagen().getContenido();
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(imagen, hh, HttpStatus.OK);

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ImagenController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/gender")
    public ResponseEntity<byte[]> imagenGenero(@RequestParam(required = true) Integer id) {

        try {
            Genero g = gs.findById(id).get();
            if (g.getImagen() == null) {
                throw new Exception("El genero no tiene una imagen asignada.");
            }
            byte[] imagen = g.getImagen().getContenido();
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(imagen, hh, HttpStatus.OK);

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ImagenController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
