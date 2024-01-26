package com.ista.talento_humano.services.primary.Service;

import com.ista.talento_humano.model.primary.Publicaciones;

import java.util.List;

public interface PublicacionesService extends GenericService<Publicaciones, Long> {
    List<Publicaciones> listarPublicacionesPorPersona(Long idPersona);

    List<Publicaciones> listarPublicacionesPorPublicacion(Long idPubli);

    String obtenerPublicacion(Long idPubli);
}
