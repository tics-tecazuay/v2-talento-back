package com.ista.talento_humano.model.secondary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "vcarrerasallppp")
public class Vcarreras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private Long id_carrera;

    @Column(name = "carrera_codigo")
    private String carrera_codigo;

    @Column(name = "carrera_nombre")
    private String carrera_nombre;

}
