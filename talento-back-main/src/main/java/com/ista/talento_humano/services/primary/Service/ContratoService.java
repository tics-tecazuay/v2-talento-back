package com.ista.talento_humano.services.primary.Service;

import com.ista.talento_humano.model.primary.Contrato;

import java.util.List;

public interface ContratoService extends GenericService<Contrato, Long>{
    List<Contrato> listarContratosPorPersona(Long idPersona);

    List<Contrato> listarContratosPorContrato(Long idContrato);

    String obtenerEvidencia(Long idContrato);
}
