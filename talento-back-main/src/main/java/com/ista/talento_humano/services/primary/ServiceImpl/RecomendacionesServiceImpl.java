package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.services.primary.Service.RecomendacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.talento_humano.model.primary.Recomendaciones;
import com.ista.talento_humano.repository.primary.RecomedacionesRepository;

import java.util.List;

@Service
public class RecomendacionesServiceImpl extends GenericServiceImpl<Recomendaciones, Long> implements RecomendacionesService {
	@Autowired
	RecomedacionesRepository recomedacionesRepository;
	@Override
	public CrudRepository<Recomendaciones, Long> getDao() {
		
		return recomedacionesRepository;
	}


	@Override
	public List<Recomendaciones> listarRecomendacionesPorPersona(Long idPersona) {
		return recomedacionesRepository.listarRecomendacionesPorPersona(idPersona);
	}

	@Override
	public List<Recomendaciones> listarRecomendacionesPorRecomendacion(Long idRecom) {
		return recomedacionesRepository.listarRecomendacionesPorRecomendacion(idRecom);
	}
}
