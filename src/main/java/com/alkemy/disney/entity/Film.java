package com.alkemy.disney.entity;


import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "film")
@Inheritance(strategy = InheritanceType.JOINED)
public class Film {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer film_id;
    private String titulo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;
    private Integer calificacion;
    @OneToOne
    private Imagen imagen;
    @OneToOne
    private Genero genero;
}
