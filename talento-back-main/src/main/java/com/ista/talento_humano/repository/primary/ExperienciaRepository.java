package com.ista.talento_humano.repository.primary;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ista.talento_humano.model.primary.Experiencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long>{

    @Query(value = "SELECT * FROM experiencia WHERE id_persona = ?", nativeQuery = true)
    List<Experiencia> listarExperienciaPorPersona(@Param("idPersona") Long idPersona);

    @Query(value = "SELECT * FROM experiencia WHERE id_experiencia = ?", nativeQuery = true)
    List<Experiencia> listarExperienciaPorExperiencia(@Param("idExp") Long idExp);

    @Query(value = "SELECT certificado_trabajo FROM experiencia WHERE id_experiencia = ?1", nativeQuery = true)
    String obtenerCertificado(@Param("idExp") Long idExp);


}
