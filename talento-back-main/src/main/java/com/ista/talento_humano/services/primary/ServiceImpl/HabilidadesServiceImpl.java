package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.services.primary.Service.HabilidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.talento_humano.model.primary.Habilidades;
import com.ista.talento_humano.repository.primary.HabilidadesRepository;

import java.util.List;

@Service
public class HabilidadesServiceImpl extends GenericServiceImpl<Habilidades, Long> implements HabilidadesService {
	@Autowired
	HabilidadesRepository habilidadesRepository;
	@Override
	public CrudRepository<Habilidades, Long> getDao() {
		
		return habilidadesRepository;
	}

	@Override
	public List<Habilidades> listarHabilidadesPorPersona(Long idPersona) {
		return habilidadesRepository.listarHabilidadesPorPersona(idPersona);
	}

	@Override
	public List<Habilidades> listarHabilidadesPorHabilidad(Long idHabilidad) {
		return habilidadesRepository.listarHabilidadesPorHabilidad(idHabilidad);
	}
}
