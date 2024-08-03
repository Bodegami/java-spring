package br.com.bodegami.cadastro.usecase;

import br.com.bodegami.cadastro.domain.Usuario;
import br.com.bodegami.cadastro.entrypoint.dto.UsuarioResponse;

public interface CadastraUsuarioUseCase {

    UsuarioResponse cadastra(Usuario usuario);

}
