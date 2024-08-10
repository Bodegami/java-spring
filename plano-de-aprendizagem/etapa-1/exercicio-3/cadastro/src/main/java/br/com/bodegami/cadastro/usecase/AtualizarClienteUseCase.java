package br.com.bodegami.cadastro.usecase;

import br.com.bodegami.cadastro.controller.dto.ClienteResponse;
import br.com.bodegami.cadastro.domain.Cliente;

public interface AtualizarClienteUseCase {

    ClienteResponse atualizar(Long id, Cliente request);

}
