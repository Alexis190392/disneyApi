package com.alkemy.disney.entity;

import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "personaje")
@Inheritance(strategy = InheritanceType.JOINED)
public class Personaje{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer personaje_id;
    
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;
    @OneToOne
    private Imagen imagen;
    @ManyToOne
    private Film film;
}
