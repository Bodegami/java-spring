package com.example.demo.domain.usecase.impl;

import com.example.demo.domain.entity.Tarefa;
import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.exception.TaskIntegrityViolationException;
import com.example.demo.domain.usecase.AtualizarTarefaUseCase;
import com.example.demo.infra.database.TarefaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class AtualizarTarefaUseCaseImpl implements AtualizarTarefaUseCase {

    @Autowired
    private TarefaRepository repository;

    @Transactional
    @Override
    public Tarefa atualizarTarefaPorId(Long id, Tarefa tarefa) {
        log.info("Inicio da chamada no AtualizarTarefaUseCase");

        Tarefa result = repository.findById(id).orElseThrow(() -> {
            var errorMessage = String.format("ID: %d - Not Found!", id);
            log.info("Erro na chamada de AtualizarTarefaUseCase | Error: {}", errorMessage);
            return new ResourceNotFoundException(errorMessage);
        });

        isValidTitle(id, tarefa, result);

        repository.save(tarefa);

        log.info("Fim da chamada no AtualizarTarefaUseCase");
        return tarefa;
    }

    private void isValidTitle(Long id, Tarefa tarefa, Tarefa result) {
        if (!tarefa.getTitulo().equalsIgnoreCase(result.getTitulo())) {
            throw new TaskIntegrityViolationException("Titulo da tarefa incompatível!");
        }

        tarefa.setId(id);
    }
}
