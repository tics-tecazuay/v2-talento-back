package com.ista.talento_humano.model.secondary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "vdocentespppall")
public class Vdocentespppall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Long id_docente;

    @Column(name = "docente_codigo")
    private String docente_codigo;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "doc_abreviatura")
    private String doc_abreviatura;

    @Column(name = "docente_tipo_tiempo")
    private String docente_tipo_tiempo;

    @Column(name = "docente_titulo")
    private String docente_titulo;
}
