package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.services.primary.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.talento_humano.model.primary.Usuario;
import com.ista.talento_humano.repository.primary.UsuarioRepository;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Long> implements UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	@Override
	public CrudRepository<Usuario, Long> getDao() {
		
		return usuarioRepository;
	}

	@Override
	public Usuario search(String username) {
		return  usuarioRepository.findByUsername(username);
	}
}
