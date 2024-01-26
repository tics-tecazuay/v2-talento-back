package com.ista.talento_humano.model.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recomendaciones")
public class Recomendaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recomendaciones")
    private Long id_recomendaciones;

    @Column(name = "primer_nombre")
    private String primer_nombre;

    @Column(name = "segundo_nombre")
    private String segundo_nombre;

    @Column(name = "primer_apellido")
    private String primer_apellido;

    @Column(name = "segundo_apellido")
    private String segundo_apellido;

    @Column(name = "correo")
    private String correo;

    @Column(name = "numeroContacto")
    private String numeroContacto;

    @Column(name = "documentoRecomendacion",columnDefinition = "TEXT")
    private String documentoRecomendacion;

    //Relation
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    


}
