package com.example.demo.infra.controller;

import com.example.demo.application.handler.TarefaHandler;
import com.example.demo.infra.controller.dto.TarefaRequest;
import com.example.demo.infra.controller.dto.TarefaResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/tarefas")
public class AtualizarTarefaController {

    @Autowired
    private TarefaHandler handler;

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponse> atualizarTarefaPorId(@PathVariable Long id, @RequestBody @Valid TarefaRequest request) {

        log.info("Inicio da chamada no AtualizarTarefaController");

        TarefaResponse response = handler.atualizarTarefaPorId(id, request);

        log.info("Fim da chamada no AtualizarTarefaController");

        return ResponseEntity.ok(response);
    }

}
