package com.example.demo.infra.controller;

import com.example.demo.application.handler.TarefaHandler;
import com.example.demo.infra.controller.dto.TarefaRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/tarefas")
public class CadastrarTarefaController {

    @Autowired
    private TarefaHandler handler;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid TarefaRequest request) {

        log.info("Inicio da chamada no CadastrarController");

        var response = handler.cadastrar(request);

        URI uri = UriComponentsBuilder.fromPath("/tarefas/{id}")
                .buildAndExpand("id", response.getId())
                .toUri();

        log.info("Fim da chamada no CadastrarController");

        return ResponseEntity.created(uri).body(response);
    }

}
