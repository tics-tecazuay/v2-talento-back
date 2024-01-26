package com.ista.talento_humano.services.primary.Service;

import com.ista.talento_humano.model.primary.Recomendaciones;

import java.util.List;

public interface RecomendacionesService extends GenericService<Recomendaciones, Long>{
    List<Recomendaciones> listarRecomendacionesPorPersona(Long idPersona);

    List<Recomendaciones> listarRecomendacionesPorRecomendacion(Long idRecom);

}
