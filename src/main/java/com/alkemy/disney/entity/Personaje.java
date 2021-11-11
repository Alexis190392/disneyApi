package com.alkemy.disney.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "personaje")
public class Personaje{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer personaje_id;
    
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;
    //@OneToOne
    //private Imagen imagen;
}
