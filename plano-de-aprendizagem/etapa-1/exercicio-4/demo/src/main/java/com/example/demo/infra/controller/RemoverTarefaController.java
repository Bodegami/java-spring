package com.example.demo.infra.controller;

import com.example.demo.application.handler.TarefaHandler;
import com.example.demo.infra.controller.dto.TarefaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tarefas")
public class RemoverTarefaController {

    @Autowired
    private TarefaHandler handler;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id) {

        log.info("Inicio da chamada no RemoverTarefaController");

        handler.deletarTarefaPorId(id);

        log.info("Fim da chamada no RemoverTarefaController");
        return ResponseEntity.noContent().build();
    }

}
