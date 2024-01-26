package com.ista.talento_humano.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ista.talento_humano.model.primary.EvaluacionDocente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EvaluacionDocenteRepository extends JpaRepository<EvaluacionDocente, Long>{
    @Query(value = "SELECT * FROM evaluacion WHERE id_persona = ?", nativeQuery = true)
    List<EvaluacionDocente> listarEvaluacionesPorPersona(@Param("idPersona") Long idPersona);

    @Query(value = "SELECT * FROM evaluacion WHERE id_evaluacion = ?", nativeQuery = true)
    List<EvaluacionDocente> listarEvaluacionesPorEvaluaciones(@Param("idEva") Long idEva);

    @Query(value = "SELECT evidencia_evaluacion FROM evaluacion WHERE id_evaluacion = ?1", nativeQuery = true)
    String obtenerEvidencia(@Param("idEva") Long idEva);
}
