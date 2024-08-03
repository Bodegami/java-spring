package br.com.bodegami.cadastro.gateway.repository;

import br.com.bodegami.cadastro.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
