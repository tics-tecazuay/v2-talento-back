package com.ista.talento_humano.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ista.talento_humano.model.primary.Horario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Long>{
    @Query(value = "SELECT * FROM horario WHERE id_persona = ?", nativeQuery = true)
    List<Horario> listarHorariosPorPersona(@Param("idPersona") Long idPersona);

    @Query(value = "SELECT * FROM horario WHERE id_horario = ?", nativeQuery = true)
    List<Horario> listarHorariosPorHorario(@Param("idHorario") Long idHorario);

    @Query(value = "SELECT distributivo FROM horario WHERE id_horario = ?1", nativeQuery = true)
    String obtenerEvidencia(@Param("idHorario") Long idHorario);

}
