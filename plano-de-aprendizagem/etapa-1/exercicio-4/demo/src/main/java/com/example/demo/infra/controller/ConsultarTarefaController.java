package com.example.demo.infra.controller;

import com.example.demo.application.handler.TarefaHandler;
import com.example.demo.infra.controller.dto.TarefaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tarefas")
public class ConsultarTarefaController {

    @Autowired
    private TarefaHandler handler;

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponse> consultarPorId(@PathVariable Long id) {

        log.info("Inicio da chamada no ConsultarPorIdController");

        var response = handler.consultarTarefaPorId(id);

        log.info("Fim da chamada no ConsultarPorIdController");

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponse>> consultarTodasTarefas() {

        log.info("Inicio da chamada no ConsultarTodasTarefasController");

        var response = handler.consultarTodasTarefas();

        log.info("Fim da chamada no ConsultarTodasTarefasController");

        return ResponseEntity.ok(response);
    }

}
