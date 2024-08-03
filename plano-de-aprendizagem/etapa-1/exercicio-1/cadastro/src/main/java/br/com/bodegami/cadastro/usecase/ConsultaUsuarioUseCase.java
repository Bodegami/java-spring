package br.com.bodegami.cadastro.usecase;

import br.com.bodegami.cadastro.entrypoint.dto.UsuarioResponse;

import java.util.List;

public interface ConsultaUsuarioUseCase {

    List<UsuarioResponse> consultaUsuarios();

    UsuarioResponse consultaUsuarioPorId(Long id);

}
