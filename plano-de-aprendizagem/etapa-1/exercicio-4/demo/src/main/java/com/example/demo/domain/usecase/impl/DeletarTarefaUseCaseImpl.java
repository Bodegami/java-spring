package com.example.demo.domain.usecase.impl;

import com.example.demo.domain.usecase.DeletarTarefaUseCase;
import com.example.demo.infra.database.TarefaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class DeletarTarefaUseCaseImpl implements DeletarTarefaUseCase {

    @Autowired
    private TarefaRepository repository;

    @Transactional
    @Override
    public void deletarTarefaPorId(Long id) {
        log.info("Inicio da chamada no DeletarTarefaUseCase");

        repository.deleteById(id);

        log.info("Fim da chamada no DeletarTarefaUseCase");
    }
}
