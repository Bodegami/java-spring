package br.com.bodegami.cadastro.usecase;

import br.com.bodegami.cadastro.controller.dto.ClienteResponse;

import java.util.List;

public interface ConsultarClienteUseCase {

    ClienteResponse buscarPorId(Long id);

    List<ClienteResponse> buscarTodos();
}
