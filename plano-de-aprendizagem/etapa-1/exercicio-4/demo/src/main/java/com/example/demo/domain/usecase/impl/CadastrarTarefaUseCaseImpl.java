package com.example.demo.domain.usecase.impl;

import com.example.demo.domain.entity.Tarefa;
import com.example.demo.domain.usecase.CadastrarTarefaUseCase;
import com.example.demo.infra.database.TarefaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class CadastrarTarefaUseCaseImpl implements CadastrarTarefaUseCase {

    @Autowired
    private TarefaRepository repository;

    @Override
    @Transactional
    public Tarefa cadastrarNovaTarefa(Tarefa tarefa) {

        log.info("Inicio da chamada no CadastroUseCase");

        var response = repository.save(tarefa);

        log.info("Fim da chamada no CadastroUseCase");
        return response;
    }
}
