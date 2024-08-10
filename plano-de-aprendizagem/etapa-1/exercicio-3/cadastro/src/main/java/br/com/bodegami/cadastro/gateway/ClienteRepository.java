package br.com.bodegami.cadastro.gateway;

import br.com.bodegami.cadastro.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
