package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.services.primary.Service.EvaluacionDocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.talento_humano.model.primary.EvaluacionDocente;
import com.ista.talento_humano.repository.primary.EvaluacionDocenteRepository;

import java.util.List;

@Service
public class EvaluacionDocenteServiceImpl extends GenericServiceImpl<EvaluacionDocente, Long> implements EvaluacionDocenteService {
	@Autowired
	EvaluacionDocenteRepository evaluacionDocenteRepository;
	@Override
	public CrudRepository<EvaluacionDocente, Long> getDao() {
		return evaluacionDocenteRepository;
	}

	@Override
	public List<EvaluacionDocente> listarEvaluacionPorPersona(Long idPersona) {
		return evaluacionDocenteRepository.listarEvaluacionesPorPersona(idPersona);
	}

	@Override
	public List<EvaluacionDocente> listarEvaluacionesPorEvaluaciones(Long idEva) {
		return evaluacionDocenteRepository.listarEvaluacionesPorEvaluaciones(idEva);
	}

	@Override
	public String obtenerEvidencia(Long idEva) {
		return evaluacionDocenteRepository.obtenerEvidencia(idEva);
	}
}
