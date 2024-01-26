package com.ista.talento_humano.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ista.talento_humano.model.primary.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);

    Boolean existsByUsername(String username);

    public Usuario findUsuarioByUsername(String username);

    Usuario findByusernameAndPassword(String username, String password);

    public boolean existsByPassword(String password);

}
