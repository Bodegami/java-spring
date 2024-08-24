package com.example.demo.domain.usecase.impl;

import com.example.demo.domain.entity.Tarefa;
import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.usecase.ConsultarTarefaUseCase;
import com.example.demo.infra.database.TarefaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
public class ConsultarTarefaUseCaseImpl implements ConsultarTarefaUseCase {

    private static final String INICIO = "Inicio da chamada no ConsultarPorUseCase: {}";
    private static final String FIM = "Fim da chamada no ConsultarPorUseCase: {}";

    @Autowired
    private TarefaRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Tarefa consultarTarefaPorId(Long id) {
        log.info(INICIO, id);

        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> {
                    String errorMessage = String.format("ID: %d - Not Found!", id);
                    log.info("Error na chamada de ConsultarPorIdUseCase | Error: {}", errorMessage);
                    return new ResourceNotFoundException(errorMessage);
                });

        log.info(FIM, tarefa);

        return tarefa;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Tarefa> consultarTodasTarefas() {
        log.info(INICIO);

        List<Tarefa> tarefas = repository.findAll();

        log.info(FIM);

        return tarefas;
    }

}
