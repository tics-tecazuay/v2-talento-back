package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.model.primary.Publicaciones;
import com.ista.talento_humano.repository.primary.PublicacionesRepository;
import com.ista.talento_humano.services.primary.Service.PublicacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionesServiceImpl extends GenericServiceImpl<Publicaciones, Long> implements PublicacionesService {

    @Autowired
    PublicacionesRepository publicacionesRepository;

    @Override
    public CrudRepository<Publicaciones, Long> getDao() {
        return publicacionesRepository;
    }

    @Override
    public List<Publicaciones> listarPublicacionesPorPersona(Long idPersona) {
        return publicacionesRepository.listarPublicacionesPorPersona(idPersona);
    }

    @Override
    public List<Publicaciones> listarPublicacionesPorPublicacion(Long idPubli) {
        return publicacionesRepository.listarPublicacionesPorPublicacion(idPubli);
    }

    @Override
    public String obtenerPublicacion(Long idCapacitaciones) {
        return publicacionesRepository.obtenerPublicacion(idCapacitaciones);
    }
}
