package br.com.bodegami.cadastro.usecase.impl;

import br.com.bodegami.cadastro.gateway.ClienteRepository;
import br.com.bodegami.cadastro.usecase.RemoverClienteUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class RemoverClienteUseCaseImpl implements RemoverClienteUseCase {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    @Override
    public void deletarPorId(Long id) {

        log.info("Inicio da chamada de RemoverClienteUseCase");

        repository.deleteById(id);

        log.info("Inicio da chamada de RemoverClienteUseCase");

    }

}
