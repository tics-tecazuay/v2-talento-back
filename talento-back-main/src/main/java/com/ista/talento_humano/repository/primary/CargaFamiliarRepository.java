package com.ista.talento_humano.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ista.talento_humano.model.primary.CargaFamiliar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CargaFamiliarRepository extends JpaRepository<CargaFamiliar, Long>{
    @Query(value = "SELECT * FROM carga_familiar WHERE id_persona = ?", nativeQuery = true)
    List<CargaFamiliar> listarCargaFamiliarPorPersona(@Param("idPersona") Long idPersona);

    @Query(value = "SELECT * FROM carga_familiar WHERE id_cargaFamiliar = ?", nativeQuery = true)
    List<CargaFamiliar> listarCargaFamiliarPorCarga(@Param("idCarga") Long idCarga);


    @Query(value = "SELECT evidencia FROM carga_familiar WHERE id_cargaFamiliar = ?1", nativeQuery = true)
    String obtenerEvidencia(@Param("idCarga") Long idCarga);
}
