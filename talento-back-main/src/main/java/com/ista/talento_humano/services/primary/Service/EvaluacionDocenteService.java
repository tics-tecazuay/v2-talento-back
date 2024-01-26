package com.ista.talento_humano.services.primary.Service;

import com.ista.talento_humano.model.primary.Contrato;
import com.ista.talento_humano.model.primary.EvaluacionDocente;

import java.util.List;

public interface EvaluacionDocenteService extends GenericService<EvaluacionDocente, Long>{

    List<EvaluacionDocente> listarEvaluacionPorPersona(Long idPersona);

    List<EvaluacionDocente> listarEvaluacionesPorEvaluaciones(Long idEva);

    String obtenerEvidencia(Long idEva);


}
