package com.ista.talento_humano.model.primary;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contrato")
public class Contrato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contrato")
	private Long id_contrato;
	
	@Column(name = "fecha_inicio")
	private Date fecha_inicio;
	
	@Column(name = "fecha_fin")
	private Date fecha_fin;
	
	@Column(name = "anio_duracion")
	private Integer anio_duracion;
	
	@Column(name = "horas_diarias")
	private Integer horas_diarias;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "salario")
	private Double salario;
	
	@Column(name = "evidencia",columnDefinition = "TEXT")
	private String evidencia;

	@Column(name = "tiempo_dedicacion")
	private String tiempo_dedicacion;

	@Column(name = "salario_publico")
	private String salario_publico;

	@Column(name = "contrato_vigente")
	private Boolean contrato_vigente;
	
	//Relation
	@ManyToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;

}
