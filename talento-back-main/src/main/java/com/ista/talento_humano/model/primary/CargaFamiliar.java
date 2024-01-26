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
@Table(name = "carga_familiar")
public class CargaFamiliar implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cargaFamiliar")
	private Long id_cargaFamiliar;
	
	@Column(name = "cedula")
	private String cedula;
	
	@Column(name = "nombre_pariente")
	private String nombre_pariente;
	
	@Column(name = "apellido_pariente")
	private String apellido_pariente;
	
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;
	
	@Column(name = "edad")
	private Integer edad;
	
	@Column(name = "evidencia", columnDefinition = "TEXT")
	private String evidencia;

	//Relation
	@ManyToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;



	
}
