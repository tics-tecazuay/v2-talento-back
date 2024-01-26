package com.ista.talento_humano.model.primary;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@Table(name = "experiencia")
public class Experiencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_experiencia")
	private Long id_experiencia;
	
	@Column(name = "institucion")
	private String institucion;
	
	@Column(name = "puesto")
	private String puesto;
	
	@Column(name = "area_trabajo")
	private String area_trabajo;
	
	@Column(name = "fecha_inicio")
	private Date fecha_inicio;
	
	@Column(name = "fecha_fin")
	private Date fecha_fin;
	
	@Column(name = "actividades")
	private String actividades;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "certificado_trabajo", columnDefinition = "TEXT")
	private String certificado_trabajo;

	//Relation
	@ManyToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;




}
