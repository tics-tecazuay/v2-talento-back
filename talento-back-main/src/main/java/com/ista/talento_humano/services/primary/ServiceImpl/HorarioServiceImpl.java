package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.services.primary.Service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.talento_humano.model.primary.Horario;
import com.ista.talento_humano.repository.primary.HorarioRepository;

import java.util.List;

@Service
public class HorarioServiceImpl extends GenericServiceImpl<Horario, Long> implements HorarioService {
	@Autowired
	HorarioRepository horarioRepository;
	@Override
	public CrudRepository<Horario, Long> getDao() {
		
		return horarioRepository;
	}


	@Override
	public List<Horario> listarHorariosPorPersona(Long idPersona) {
		return horarioRepository.listarHorariosPorPersona(idPersona);
	}

	@Override
	public List<Horario> listarHorariosPorHorario(Long idHorario) {
		return horarioRepository.listarHorariosPorHorario(idHorario);
	}

	@Override
	public String obtenerDistributivo(Long idHorario) {
		return horarioRepository.obtenerEvidencia(idHorario);
	}
	
}
