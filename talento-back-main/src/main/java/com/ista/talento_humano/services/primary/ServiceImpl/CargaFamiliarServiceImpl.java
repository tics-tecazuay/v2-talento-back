package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.services.primary.Service.CargaFamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.talento_humano.model.primary.CargaFamiliar;
import com.ista.talento_humano.repository.primary.CargaFamiliarRepository;

import java.util.List;

@Service
public class CargaFamiliarServiceImpl extends GenericServiceImpl<CargaFamiliar, Long> implements CargaFamiliarService {
	@Autowired
	CargaFamiliarRepository cargaFamiliarRepository;
	@Override
	public CrudRepository<CargaFamiliar, Long> getDao() {
		
		return cargaFamiliarRepository;
	}

	@Override
	public List<CargaFamiliar> listarCargaFamiliarPorPersona(Long idPersona) {
		return cargaFamiliarRepository.listarCargaFamiliarPorPersona(idPersona);
	}

	@Override
	public List<CargaFamiliar> listarCargaFamiliarPorCarga(Long idCarga) {
		return cargaFamiliarRepository.listarCargaFamiliarPorCarga(idCarga);
	}

	@Override
	public String obtenerEvidencia(Long idCarga) {
		return cargaFamiliarRepository.obtenerEvidencia(idCarga);
	}
}
