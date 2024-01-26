package com.ista.talento_humano.services.primary.Service;

import com.ista.talento_humano.model.primary.CargaFamiliar;

import java.util.List;

public interface CargaFamiliarService extends GenericService<CargaFamiliar, Long>{
    List<CargaFamiliar> listarCargaFamiliarPorPersona(Long idPersona);

    List<CargaFamiliar> listarCargaFamiliarPorCarga(Long idCarga);

    String obtenerEvidencia(Long idCarga);
}
