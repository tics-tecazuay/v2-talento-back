package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.services.primary.Service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.talento_humano.model.primary.Contrato;
import com.ista.talento_humano.repository.primary.ContratoRepository;

import java.util.List;

@Service
public class ContratoServiceImpl extends GenericServiceImpl<Contrato, Long> implements ContratoService {
	@Autowired
	ContratoRepository contratoRepository;
	@Override
	public CrudRepository<Contrato, Long> getDao() {
		
		return contratoRepository;
	}


	@Override
	public List<Contrato> listarContratosPorPersona(Long idPersona) {
		return contratoRepository.listarContratosPorPersona(idPersona);
	}

	@Override
	public List<Contrato> listarContratosPorContrato(Long idContrato) {
		return contratoRepository.listarContratosPorContrato(idContrato);
	}

	@Override
	public String obtenerEvidencia(Long idContrato) {
		return contratoRepository.obtenerEvidencia(idContrato);
	}

}
