package com.ista.talento_humano.services.primary.Service;


import com.ista.talento_humano.model.primary.Experiencia;

import java.util.List;

public interface ExperienciaService extends GenericService<Experiencia, Long>{
    List<Experiencia> listarExperienciaPorPersona(Long idPersona);

    List<Experiencia> listarExperienciaPorExperiencia(Long idExp);

    String obtenerCertificado(Long idExp);
}
