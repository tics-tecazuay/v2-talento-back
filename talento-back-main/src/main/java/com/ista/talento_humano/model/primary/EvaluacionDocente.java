package com.ista.talento_humano.model.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "evaluacion")
public class EvaluacionDocente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evaluacion")
    private Long id_evaluacion;
    
    @Column(name = "cod_carrera")
    private String cod_carrera;
    
    @Column(name = "evidencia_evaluacion", columnDefinition = "TEXT")
    private String evidencia_evaluacion;

    @Column(name = "per_nombre")
    private String per_nombre;


    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;



}
