package com.ista.talento_humano.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ista.talento_humano.model.primary.Habilidades;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HabilidadesRepository extends JpaRepository<Habilidades, Long> {
    @Query(value = "SELECT * FROM habilidades WHERE id_persona = ?", nativeQuery = true)
    List<Habilidades> listarHabilidadesPorPersona(@Param("idPersona") Long idPersona);

    @Query(value = "SELECT * FROM habilidades WHERE id_habilidades = ?", nativeQuery = true)
    List<Habilidades> listarHabilidadesPorHabilidad(@Param("idHabilidad") Long idHabilidad);
}
