package com.ista.talento_humano.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;      
import com.ista.talento_humano.model.primary.Contrato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    @Query(value = "SELECT * FROM contrato WHERE id_persona = ?", nativeQuery = true)
    List<Contrato> listarContratosPorPersona(@Param("idPersona") Long idPersona);

    @Query(value = "SELECT * FROM contrato WHERE id_contrato = ?", nativeQuery = true)
    List<Contrato> listarContratosPorContrato(@Param("idContrato") Long idContrato);

    @Query(value = "SELECT evidencia FROM contrato WHERE id_contrato = ?1", nativeQuery = true)
    String obtenerEvidencia(@Param("idContrato") Long idContrato);
}
