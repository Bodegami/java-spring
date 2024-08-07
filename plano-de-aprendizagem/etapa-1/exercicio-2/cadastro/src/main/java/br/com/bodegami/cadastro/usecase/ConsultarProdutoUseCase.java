package br.com.bodegami.cadastro.usecase;

import br.com.bodegami.cadastro.entrypoint.dto.ProdutoResponse;

import java.util.List;

public interface ConsultarProdutoUseCase {

    ProdutoResponse consultarPorId(Long id);

    List<ProdutoResponse> consultarTodosProdutos();

}
