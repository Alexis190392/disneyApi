package com.alkemy.disney.entity;

import com.alkemy.disney.enums.Role;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario /*implements UserDetails*/{
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer user_id;
   // private String nombre;
    private String email;
    private String username;
    private String password;
    private ArrayList<Role> rol;

}