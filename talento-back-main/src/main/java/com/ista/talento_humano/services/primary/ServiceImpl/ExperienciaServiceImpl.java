package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.services.primary.Service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.talento_humano.model.primary.Experiencia;
import com.ista.talento_humano.repository.primary.ExperienciaRepository;

import java.util.List;

@Service
public class ExperienciaServiceImpl extends GenericServiceImpl<Experiencia, Long> implements ExperienciaService {
	@Autowired
	ExperienciaRepository experienciaRepository;
	@Override
	public CrudRepository<Experiencia, Long> getDao() {
		
		return experienciaRepository;
	}

	@Override
	public List<Experiencia> listarExperienciaPorPersona(Long idPersona) {
		return experienciaRepository.listarExperienciaPorPersona(idPersona);
	}

	@Override
	public List<Experiencia> listarExperienciaPorExperiencia(Long idExp) {
		return experienciaRepository.listarExperienciaPorExperiencia(idExp);
	}

	@Override
	public String obtenerCertificado(Long idExp) {
		return experienciaRepository.obtenerCertificado(idExp);
	}


}
