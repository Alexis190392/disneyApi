package com.alkemy.disney.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "genero")
public class Genero {
    @Id
    private String nombre;
    @OneToOne
    private Imagen imagen;
    
}
