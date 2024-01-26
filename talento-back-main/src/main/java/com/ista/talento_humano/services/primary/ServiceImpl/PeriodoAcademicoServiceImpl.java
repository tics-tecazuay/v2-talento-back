package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.services.primary.Service.PeriodoAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.talento_humano.model.primary.PeriodoAcademico;
import com.ista.talento_humano.repository.primary.PeriodoAcademicoRepository;

@Service
public class PeriodoAcademicoServiceImpl extends GenericServiceImpl<PeriodoAcademico, Long> implements PeriodoAcademicoService {
	@Autowired
	PeriodoAcademicoRepository PeriodoAcademicoRepository;
	@Override
	public CrudRepository<PeriodoAcademico, Long> getDao() {
		return PeriodoAcademicoRepository;
	}
	
}
