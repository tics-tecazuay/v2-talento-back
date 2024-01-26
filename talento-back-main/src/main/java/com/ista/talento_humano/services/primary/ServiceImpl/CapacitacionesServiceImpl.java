package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.services.primary.Service.CapacitacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.talento_humano.model.primary.Capacitaciones;
import com.ista.talento_humano.repository.primary.CapacitacionesRepository;

import java.util.List;

@Service
public class CapacitacionesServiceImpl extends GenericServiceImpl<Capacitaciones, Long> implements CapacitacionesService {
	@Autowired
	CapacitacionesRepository capacitacionesRepository;
	@Override
	public CrudRepository<Capacitaciones, Long> getDao() {
		return capacitacionesRepository;
	}


	@Override
	public List<Capacitaciones> listarCapacitacionesPorPersona(Long idPersona) {
		return capacitacionesRepository.listarCapacitacionesPorPersona(idPersona);
	}

	@Override
	public List<Capacitaciones> listarCapacitacionesPorCapacitaciones(Long idCapacitaciones) {
		return capacitacionesRepository.listarCapacitacionesPorCapacitaciones(idCapacitaciones);
	}

	@Override
	public String obtenerEvidencia(Long idCapacitaciones) {
		return capacitacionesRepository.obtenerEvidencia(idCapacitaciones);
	}
}
