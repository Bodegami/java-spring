package com.example.demo.application.handler.impl;

import com.example.demo.application.handler.TarefaHandler;
import com.example.demo.application.mapper.RequestMapper;
import com.example.demo.application.mapper.ResponseMapper;
import com.example.demo.domain.entity.Tarefa;
import com.example.demo.domain.usecase.AtualizarTarefaUseCase;
import com.example.demo.domain.usecase.CadastrarTarefaUseCase;
import com.example.demo.domain.usecase.ConsultarTarefaUseCase;
import com.example.demo.domain.usecase.DeletarTarefaUseCase;
import com.example.demo.infra.controller.dto.TarefaRequest;
import com.example.demo.infra.controller.dto.TarefaResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TarefaHandlerImpl implements TarefaHandler {

    @Autowired
    private RequestMapper requestMapper;

    @Autowired
    private ResponseMapper responseMapper;

    @Autowired
    private CadastrarTarefaUseCase cadastroUseCase;

    @Autowired
    private ConsultarTarefaUseCase consultaUseCase;

    @Autowired
    private DeletarTarefaUseCase deletarUseCase;

    @Autowired
    private AtualizarTarefaUseCase atualizarUseCase;

    @Override
    public TarefaResponse cadastrar(TarefaRequest request) {
        try {
            log.info("Inicio da chamada no handler - cadastro");

            var tarefa = requestMapper.toDomain(request);

            tarefa = cadastroUseCase.cadastrarNovaTarefa(tarefa);

            log.info("Fim da chamada no handler - cadastro");
            return responseMapper.toResponse(tarefa);
        }
        catch (Exception e) {
            log.error("ERROR na chamada do handler | cadastro | {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TarefaResponse> consultarTodasTarefas() {
        log.info("Inicio da chamada no handler - consulta todas");

        List<TarefaResponse> response = consultaUseCase.consultarTodasTarefas().stream()
                .map(responseMapper::toResponse)
                .toList();

        log.info("Fim da chamada no handler - consulta todas");
        return response;
    }

    @Override
    public TarefaResponse consultarTarefaPorId(Long id) {
        log.info("Inicio da chamada no handler - consulta por id: {}", id);

        var tarefa = consultaUseCase.consultarTarefaPorId(id);

        TarefaResponse response = responseMapper.toResponse(tarefa);

        log.info("Fim da chamada no handler - consulta por id: {}", id);
        return response;
    }

    @Override
    public void deletarTarefaPorId(Long id) {
        log.info("Inicio da chamada no handler - deletar por id: {}", id);

        deletarUseCase.deletarTarefaPorId(id);

        log.info("Fim da chamada no handler - deletar por id: {}", id);
    }

    @Override
    public TarefaResponse atualizarTarefaPorId(Long id, TarefaRequest request) {

        Tarefa tarefa = requestMapper.toDomain(request);

        Tarefa response = atualizarUseCase.atualizarTarefaPorId(id, tarefa);

        return responseMapper.toResponse(tarefa);
    }

}
