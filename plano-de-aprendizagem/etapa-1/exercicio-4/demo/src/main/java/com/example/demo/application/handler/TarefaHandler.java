package com.example.demo.application.handler;

import com.example.demo.infra.controller.dto.TarefaRequest;
import com.example.demo.infra.controller.dto.TarefaResponse;

import java.util.List;

public interface TarefaHandler {

    TarefaResponse cadastrar(TarefaRequest request);

    List<TarefaResponse> consultarTodasTarefas();

    TarefaResponse consultarTarefaPorId(Long id);

    void deletarTarefaPorId(Long id);

    TarefaResponse atualizarTarefaPorId(Long id, TarefaRequest request);
}
