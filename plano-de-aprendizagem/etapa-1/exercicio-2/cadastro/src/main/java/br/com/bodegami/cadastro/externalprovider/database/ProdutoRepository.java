package br.com.bodegami.cadastro.externalprovider.database;

import br.com.bodegami.cadastro.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
