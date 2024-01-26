package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.services.primary.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.talento_humano.model.primary.Rol;
import com.ista.talento_humano.repository.primary.RolRepository;

@Service
public class RolServiceImpl extends GenericServiceImpl<Rol, Long> implements RolService {
	@Autowired
	RolRepository rolRepository;
	@Override
	public CrudRepository<Rol, Long> getDao() {
		
		return rolRepository;
	}
	

}
