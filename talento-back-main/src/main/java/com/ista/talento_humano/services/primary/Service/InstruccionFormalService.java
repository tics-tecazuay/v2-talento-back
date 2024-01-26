package com.ista.talento_humano.services.primary.Service;

import com.ista.talento_humano.model.primary.InstruccionFormal;

import java.util.List;

public interface InstruccionFormalService extends GenericService<InstruccionFormal, Long>{
    List<InstruccionFormal> listarInstruccionFormalPorPersona(Long idPersona);

    List<InstruccionFormal> listarInstruccionFormalPorIntruccion(Long idInstruccion);

    String obtenerTitulo(Long idInstruccion);
}
