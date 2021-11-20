package com.alkemy.disney.controller;

import com.alkemy.disney.entity.Usuario;
import com.alkemy.disney.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/auth")
public class UsuarioController {
    
    @Autowired
    private UsuarioService us;
    
    @PostMapping("/register")
    public Usuario registro(@RequestParam(required = true) String email,
                            @RequestParam(required = true) String username,
                            @RequestParam(required = true) String password){
        
        return us.crearUsuario(email, username, password);
    }
    
//    @PostMapping("/login")
//    public String iniciarSesion(Model model, 
//                                @RequestParam(required=true) String loginTrue,
//                                @RequestParam(required=true) String loginFalse,
//                                @RequestParam(required=true) String username,
//                                @RequestParam(required=true) String password,
//                                RedirectAttributes redat){
//        
//        
//    }
    
    @GetMapping("/login")
    public String iniciarSesion(Model model,
                                @RequestParam(required = false) String error,
                                @RequestParam(required = false) String username,
                                @RequestParam(required = false) String logout){
        if(error != null){
            model.addAttribute("error", "Usuario o contraseña invalido");
        }
        if(username != null){
            model.addAttribute("username",username);
        }
        return "login";
    }
    
    
}
