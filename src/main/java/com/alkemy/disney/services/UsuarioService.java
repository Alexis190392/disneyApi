package com.alkemy.disney.services;

import com.alkemy.disney.entity.Usuario;
import com.alkemy.disney.enums.Role;
import com.alkemy.disney.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository ur;
    
    @Transactional
    public Usuario crearUsuario(Usuario usuario){
        return ur.save(usuario);
    }
    
    @Transactional
    public Usuario crearUsuario(String mail, String username, String password){
        Usuario u = new Usuario();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        u.setEmail(mail);
        u.setUsername(username);
        u.setPassword(encoder.encode(password));
        u.setRol(Role.USER);
        return ur.save(u);
    }
    
    public Usuario findByUsername(String username){
        return ur.findByUsername(username);
    }
    
    public Usuario findByEmail(String mail){
        return ur.findByEmail(mail);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = ur.findByUsername(username);
        try{
            User user;
            List<GrantedAuthority> permisos = new ArrayList<>();
            
            permisos.add(new SimpleGrantedAuthority("ROLE_" + u.getRol()));
            
            return new User(username, u.getPassword(), permisos);
        }catch (Exception e){
            throw new UsernameNotFoundException("Username no existente.");
        }
        
        
    }
    
    
}
