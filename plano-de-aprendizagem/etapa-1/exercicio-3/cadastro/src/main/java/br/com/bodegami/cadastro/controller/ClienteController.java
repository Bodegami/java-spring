package br.com.bodegami.cadastro.controller;

import br.com.bodegami.cadastro.controller.dto.ClienteRequest;
import br.com.bodegami.cadastro.controller.dto.ClienteResponse;
import br.com.bodegami.cadastro.controller.mapper.ClienteRequestMapper;
import br.com.bodegami.cadastro.usecase.AtualizarClienteUseCase;
import br.com.bodegami.cadastro.usecase.CadastrarClienteUseCase;
import br.com.bodegami.cadastro.usecase.ConsultarClienteUseCase;
import br.com.bodegami.cadastro.usecase.RemoverClienteUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRequestMapper mapper;

    @Autowired
    private CadastrarClienteUseCase cadastrarClienteUseCase;

    @Autowired
    private ConsultarClienteUseCase consultarClienteUseCase;

    @Autowired
    private AtualizarClienteUseCase atualizarClienteUseCase;

    @Autowired
    private RemoverClienteUseCase removerClienteUseCase;

    @PostMapping
    private ResponseEntity<ClienteResponse> cadastrar(@RequestBody @Valid ClienteRequest request) {

        log.info("Inicio da chamada de Cadastro");

        var cliente = mapper.toDomain(request);

        ClienteResponse response = cadastrarClienteUseCase.cadastrar(cliente);

        URI uri = UriComponentsBuilder.fromPath("/clientes/{id}")
                .buildAndExpand("id", cliente.getId())
                .toUri();

        log.info("Fim da chamada de Cadastro");

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> consultarPorId(@PathVariable Long id) {

        log.info("Inicio da chamada de Consulta por ID");

        ClienteResponse response = consultarClienteUseCase.buscarPorId(id);

        log.info("Fim da chamada de Consulta por ID");

        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<List<ClienteResponse>> consultarTodos() {

        log.info("Inicio da chamada de Consulta todos os Clientes");

        List<ClienteResponse> response = consultarClienteUseCase.buscarTodos();

        log.info("Fim da chamada de Consulta todos os Clientes");

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> atualizarClientePorId(@PathVariable Long id, @RequestBody @Valid ClienteRequest request) {

        log.info("Inicio da chamada de Atualizar Cliente por ID");

        var cliente = mapper.toDomain(request);

        ClienteResponse response = atualizarClienteUseCase.atualizar(id, cliente);

        log.info("Fim da chamada de Atualizar Cliente por ID");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {

        log.info("Inicio da chamada de Remover Cliente por ID");

        removerClienteUseCase.deletarPorId(id);

        log.info("Fim da chamada de Remover Cliente por ID");

        return ResponseEntity
                .noContent()
                .build();
    }



}
