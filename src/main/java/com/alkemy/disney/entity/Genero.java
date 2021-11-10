package com.alkemy.disney.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "genero")
public class Genero {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer genero_id;
    private String nombre;
    @OneToOne
    private Imagen imagen;
    
}
