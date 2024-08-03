package br.com.bodegami.cadastro.usecase.impl;

import br.com.bodegami.cadastro.domain.Usuario;
import br.com.bodegami.cadastro.domain.exception.ResourceNotFoundException;
import br.com.bodegami.cadastro.entrypoint.dto.UsuarioResponse;
import br.com.bodegami.cadastro.gateway.repository.UsuarioRepository;
import br.com.bodegami.cadastro.usecase.ConsultaUsuarioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ConsultaUsuarioUseCaseImpl implements ConsultaUsuarioUseCase {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<UsuarioResponse> consultaUsuarios() {

        List<Usuario> usuarios = repository.findAll();

        List<UsuarioResponse> response = usuarios.stream()
                .map(UsuarioResponse::new)
                .toList();

        return response;
    }

    @Override
    public UsuarioResponse consultaUsuarioPorId(Long id) {

        Optional<Usuario> response = repository.findById(id);

        Usuario usuario = response.orElseThrow(() -> new ResourceNotFoundException(String.format("Não foi encontado usuário de ID: %s", id)));

        return new UsuarioResponse(usuario);
    }
}
