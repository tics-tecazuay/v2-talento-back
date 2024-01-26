package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.services.primary.Service.InstruccionFormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.talento_humano.model.primary.InstruccionFormal;
import com.ista.talento_humano.repository.primary.InstruccionFormalRepository;

import java.util.List;

@Service
public class InstruccionFormalServiceImpl extends GenericServiceImpl<InstruccionFormal, Long> implements InstruccionFormalService {
	@Autowired
	InstruccionFormalRepository instruccionFormalRepository;

	@Override
	public CrudRepository<InstruccionFormal, Long> getDao() {
		
		return instruccionFormalRepository;
	}

	@Override
	public List<InstruccionFormal> listarInstruccionFormalPorPersona(Long idPersona) {
		return instruccionFormalRepository.listarInstruccionFormalPorPersona(idPersona);
	}

	@Override
	public List<InstruccionFormal> listarInstruccionFormalPorIntruccion(Long idInstruccion) {
		return instruccionFormalRepository.listarInstruccionFormalPorIntruccion(idInstruccion);
	}


	@Override
	public String obtenerTitulo(Long idInstruccion) {
		return instruccionFormalRepository.obtenerTitulo(idInstruccion);
	}

}
