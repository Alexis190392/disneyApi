package com.alkemy.disney.controller;

import com.alkemy.disney.entity.Genero;
import com.alkemy.disney.services.GeneroService;
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
@RequestMapping("/genre")
public class GeneroController {
    
    @Autowired
    private GeneroService gs;
    
    @GetMapping()
    public List<Genero> listarGeneros(){
        return gs.listAll();
    }
    
    @PostMapping
    public Genero agregarGenero(@RequestBody Genero gender,
                                @RequestParam(required = false) MultipartFile image){
        return gs.crearGenero(gender,image);
    }
    
    @GetMapping("/delete")
    public Boolean eliminarGenero(@RequestParam(required = true) Integer gender_id){
        return gs.eliminarGenero(gender_id);
    }
    
    
}
