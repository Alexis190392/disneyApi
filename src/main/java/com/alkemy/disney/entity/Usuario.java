package com.alkemy.disney.entity;

import com.alkemy.disney.enums.Role;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer user_id;
   // private String nombre;
    private String email;
    private String username;
    private String password;
    @Enumerated
    private Role rol;
    
}
