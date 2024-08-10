package br.com.bodegami.cadastro.usecase;

import br.com.bodegami.cadastro.controller.dto.ClienteResponse;
import br.com.bodegami.cadastro.domain.Cliente;

public interface CadastrarClienteUseCase {

    ClienteResponse cadastrar(Cliente cliente);

}
