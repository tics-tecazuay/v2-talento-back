package com.ista.talento_humano.services.primary.Service;


import com.ista.talento_humano.model.primary.Capacitaciones;


import java.util.List;

public interface CapacitacionesService extends GenericService<Capacitaciones, Long>{

    List<Capacitaciones> listarCapacitacionesPorPersona(Long idPersona);

    List<Capacitaciones> listarCapacitacionesPorCapacitaciones(Long idCapacitaciones);
    String obtenerEvidencia(Long idCapacitaciones);


}
