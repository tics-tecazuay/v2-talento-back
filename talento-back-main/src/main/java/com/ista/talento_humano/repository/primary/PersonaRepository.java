package com.ista.talento_humano.repository.primary;

import com.ista.talento_humano.model.primary.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PersonaRepository extends JpaRepository<Persona, Long> {
    public Persona findByCedula(String cedula);
    @Query(value = "SELECT id_persona, apellido_materno, apellido_paterno, calles, canton_residencia, carnet_conadis, cedula, celular, correo,correo_institucional, descripcion_perfil, discapacidad, edad, estado_civil, etnia, fecha_nacimiento, genero, idioma_raiz, idioma_secundario, numero_casa, pais_natal, pais_residencia, parroquia_residencia, porcentaje_discapacidad, provincia_residencia, primer_nombre, referencia,sector, segundo_nombre, sexo, telefono, tipo_discapacidad, tipo_sangre, null as cv_socioempleo, null as mecanizado_iess, null as documentos_personales, null as foto_carnet, null as foto  FROM persona WHERE id_persona = ?", nativeQuery = true)
    List<Persona> listarPersona(@Param("idPersona") Long idPersona);

    @Query(value = "SELECT cv_socioempleo FROM persona WHERE id_persona = ?1", nativeQuery = true)
    String obtenerCvEmpleado(@Param("idPersona") Long idPersona);
    @Query(value = "SELECT mecanizado_iess FROM persona WHERE id_persona = ?1", nativeQuery = true)
    String obtenerMecaiess(@Param("idPersona") Long idPersona);
    @Query(value = "SELECT documentos_personales FROM persona WHERE id_persona = ?1", nativeQuery = true)
    String obtenerDocpers(@Param("idPersona") Long idPersona);
    
}

//@Query(value = "SELECT id_persona, apellido_materno, apellido_paterno, calles, canton_residencia, carnet_conadis, cedula, celular, correo,correo_institucional, descripcion_perfil, discapacidad, edad, estado_civil, etnia, fecha_nacimiento, genero, idioma_raiz, idioma_secundario, numero_casa, pais_natal, pais_residencia, parroquia_residencia, porcentaje_discapacidad, provincia_residencia, primer_nombre, referencia,sector, segundo_nombre, sexo, telefono, tipo_discapacidad, tipo_sangre  FROM persona WHERE id_persona = ?", nativeQuery = true)
//List<Persona> listarPersona(@Param("idPersona") Long idPersona);