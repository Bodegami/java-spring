package br.com.bodegami.cadastro.usecase.impl;

import br.com.bodegami.cadastro.domain.Usuario;
import br.com.bodegami.cadastro.entrypoint.dto.UsuarioResponse;
import br.com.bodegami.cadastro.gateway.repository.UsuarioRepository;
import br.com.bodegami.cadastro.usecase.AtualizaUsuarioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizaUsuarioUseCaseImpl implements AtualizaUsuarioUseCase {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UsuarioResponse atualiza(Long id, Usuario usuario) {

        Usuario userReference = repository.getReferenceById(id);

        Usuario usuarioAtualizado = updateFields(usuario, userReference);

        repository.save(usuarioAtualizado);

        return new UsuarioResponse(usuarioAtualizado);
    }

    private Usuario updateFields(Usuario userRequest, Usuario userReference) {

        if (userRequest.getNome() != null && !userRequest.getNome().isEmpty()) {
            userReference.setNome(userRequest.getNome());
        }

        if (userRequest.getEmail() != null && !userRequest.getEmail().isEmpty()) {
            userReference.setEmail(userRequest.getEmail());
        }

        if (userRequest.getSenha() != null && !userRequest.getSenha().isEmpty()) {
            userReference.setSenha(userRequest.getSenha());
        }

        return userReference;

    }

}
