package com.ista.talento_humano.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ista.talento_humano.model.primary.Recomendaciones;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecomedacionesRepository extends JpaRepository<Recomendaciones, Long>{
    @Query(value = "SELECT * FROM recomendaciones WHERE id_persona = ?", nativeQuery = true)
    List<Recomendaciones> listarRecomendacionesPorPersona(@Param("idPersona") Long idPersona);

    @Query(value = "SELECT * FROM recomendaciones WHERE id_recomendaciones = ?", nativeQuery = true)
    List<Recomendaciones> listarRecomendacionesPorRecomendacion(@Param("idRecom") Long idRecom);
}
