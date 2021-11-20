package com.alkemy.disney.repository;

import com.alkemy.disney.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("select u from Usuario u where u.username = :username")
    Usuario findByUsername(@Param("username") String username);
    
    @Query("select u from Usuario u where u.email = :mail")
    Usuario findByEmail(@Param("mail") String mail);
    
}
