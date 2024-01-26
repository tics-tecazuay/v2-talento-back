package com.ista.talento_humano.services.primary.Service;

import com.ista.talento_humano.model.primary.Horario;

import java.util.List;

public interface HorarioService extends GenericService<Horario, Long>{
    List<Horario> listarHorariosPorPersona(Long idPersona);

    List<Horario> listarHorariosPorHorario(Long idHorario);

    String obtenerDistributivo(Long idHorario);
}
