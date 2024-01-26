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
@Table(name = "instruccion_formal")
public class InstruccionFormal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instruccion")
    private Long id_instruccion;

    @Column(name = "nivel_instruccion")
    private String nivelInstruccion;

    @Column(name = "institucion_educativa")
    private String institucionEducativa;

    @Column(name = "titulo_obtenido")
    private String tituloObtenido;

    @Column(name = "No_RegistroSenescyt")
    private String num_SenecytRegistro;

    @Column(name = "tiempo_estudio")
    private Double tiempoEstudio;

    @Column(name = "anio_graduacion")
    private int anioGraduacion;

    @Column(name = "area_estudios")
    private String areaEstudios;

    @Column(name = "titulo",columnDefinition = "TEXT")
    private String titulo;

	//Relation
	@ManyToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;


    
}
