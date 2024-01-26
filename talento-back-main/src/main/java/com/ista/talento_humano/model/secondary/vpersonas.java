package com.ista.talento_humano.model.secondary;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.Immutable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vpersonas")
public class vpersonas {

	@Id
	@Column(name = "cedula")
	private String cedula;

	@Column(name = "apellido_paterno")
	private String apellido_paterno;

	@Column(name = "apellido_materno")
	private String apellido_materno;

	@Column(name = "primer_nombre")
	private String primer_nombre;

	@Column(name = "segundo_nombre")
	private String segundo_nombre;

	@Column(name = "fecha_nacimiento")
	private String fecha_nacimiento;

	@Column(name = "pais_natal")
	private String pais_natal;

	@Column(name = "genero")
	private String genero;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "tipo_sangre")
	private String tipo_sangre;

	@Column(name = "estado_civil")
	private String estado_civil;

	@Column(name = "etnia")
	private String etnia;

	@Column(name = "idioma_raiz")
	private String idioma_raiz;

	@Column(name = "idioma_secundario")
	private String idioma_secundario;

	////////////////////////////////////////////

	@Column(name = "calles")
	private String calles;

	@Column(name = "numero_casa")
	private String numero_casa;

	@Column(name = "sector")
	private String sector;

	@Column(name = "referencia")
	private String referencia;

	//////////////////////////////////////////////////

	@Column(name = "celular")
	private String celular;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "correo")
	private String correo;

	@Column(name = "correo_institucional")
	private String correo_institucional;

	///////////////////////////////////////////////

	@Column(name = "discapacidad")
	private String discapacidad;

	@Column(name = "tipo_discapacidad")
	private String tipo_discapacidad;

	@Column(name = "porcentaje_discapacidad")
	private String porcentaje_discapacidad;

	@Column(name = "carnet_conadis")
	private String carnet_conadis;


}