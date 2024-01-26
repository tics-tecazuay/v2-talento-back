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
@Table(name = "capacitaciones")
public class Capacitaciones implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_capacitaciones")
	private Long id_capacitaciones;
	
	@Column(name = "institucion")
	private String institucion;
	
	@Column(name = "tipo_evento")
	private String tipo_evento;
	
	@Column(name = "nombre_evento")
	private String nombre_evento;
	
	@Column(name = "area_estudios")
	private String area_estudios;
	
	@Column(name = "tipo_certificado")
	private String tipo_certificado;
	
	@Column(name = "fecha_inicio")
	private Date fecha_inicio;
	
	@Column(name = "fecha_fin")
	private Date fecha_fin;
	
	@Column(name = "numero_dias")
	private Integer numero_dias;
	
	@Column(name = "cantidad_horas")
	private Integer cantidad_horas;

	@Column(name = "evidencia", columnDefinition = "TEXT")
	private String evidencia;
	
	//Relation
	@ManyToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;


	
}
