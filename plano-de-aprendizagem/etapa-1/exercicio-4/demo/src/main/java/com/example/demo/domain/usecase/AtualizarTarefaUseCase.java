package com.example.demo.domain.usecase;

import com.example.demo.domain.entity.Tarefa;

public interface AtualizarTarefaUseCase {

    Tarefa atualizarTarefaPorId(Long id, Tarefa tarefa);

}
