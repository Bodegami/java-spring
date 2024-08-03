package br.com.bodegami.cadastro.usecase.impl;

import br.com.bodegami.cadastro.gateway.repository.UsuarioRepository;
import br.com.bodegami.cadastro.usecase.DeletaUsuarioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletaUsuarioUseCaseImpl implements DeletaUsuarioUseCase {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void deletaPorId(Long id) {
        repository.deleteById(id);
    }
}
