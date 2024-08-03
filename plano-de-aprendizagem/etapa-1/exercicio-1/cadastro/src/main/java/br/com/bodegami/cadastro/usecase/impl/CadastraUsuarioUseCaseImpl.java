package br.com.bodegami.cadastro.usecase.impl;

import br.com.bodegami.cadastro.domain.Usuario;
import br.com.bodegami.cadastro.entrypoint.dto.UsuarioResponse;
import br.com.bodegami.cadastro.gateway.repository.UsuarioRepository;
import br.com.bodegami.cadastro.usecase.CadastraUsuarioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraUsuarioUseCaseImpl implements CadastraUsuarioUseCase {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UsuarioResponse cadastra(Usuario usuario) {

        Usuario usuarioSalvo = repository.save(usuario);

        UsuarioResponse response = new UsuarioResponse(usuarioSalvo);

        return response;
    }
}
