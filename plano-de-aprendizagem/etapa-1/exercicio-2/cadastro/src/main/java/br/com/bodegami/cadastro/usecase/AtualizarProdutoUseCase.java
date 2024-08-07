package br.com.bodegami.cadastro.usecase;

import br.com.bodegami.cadastro.domain.Produto;
import br.com.bodegami.cadastro.entrypoint.dto.ProdutoResponse;

public interface AtualizarProdutoUseCase {

    ProdutoResponse atualizaProduto(Long id, Produto produto);

}
