package com.ista.talento_humano.services.primary.Service;

import com.ista.talento_humano.model.primary.Habilidades;

import java.util.List;

public interface HabilidadesService extends GenericService<Habilidades, Long>{
    List<Habilidades> listarHabilidadesPorPersona(Long idPersona);

    List<Habilidades> listarHabilidadesPorHabilidad(Long idHabilidad);
}
