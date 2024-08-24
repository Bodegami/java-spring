package com.example.demo.domain.usecase;

import com.example.demo.domain.entity.Tarefa;
import com.example.demo.infra.controller.dto.TarefaResponse;

import java.util.List;

public interface ConsultarTarefaUseCase {

    List<Tarefa> consultarTodasTarefas();

    Tarefa consultarTarefaPorId(Long id);
}
