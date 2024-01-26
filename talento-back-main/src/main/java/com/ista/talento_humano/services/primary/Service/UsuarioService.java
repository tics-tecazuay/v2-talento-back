package com.ista.talento_humano.services.primary.Service;

import com.ista.talento_humano.model.primary.Usuario;

public interface UsuarioService extends GenericService<Usuario, Long>{
    public Usuario search(String username);

}
