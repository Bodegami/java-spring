package br.com.bodegami.cadastro.usecase.impl;

import br.com.bodegami.cadastro.controller.dto.ClienteResponse;
import br.com.bodegami.cadastro.gateway.ClienteRepository;
import br.com.bodegami.cadastro.usecase.ConsultarClienteUseCase;
import br.com.bodegami.cadastro.usecase.mapper.ClienteResponseMapper;
import br.com.bodegami.cadastro.utils.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
public class ConsultarClienteUseCaseImpl implements ConsultarClienteUseCase {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteResponseMapper mapper;

    @Transactional(readOnly = true)
    @Override
    public ClienteResponse buscarPorId(Long id) {

        log.info("Inicio da chamada de ConsultarClienteUseCase");

        ClienteResponse response = repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> {
                    String errorMessage = String.format("ID: %d - Not Found!", id);
                    log.info(String.format("Error na chamada de ConsultarClienteUseCase | Error: %s", errorMessage));
                    return new ResourceNotFoundException(errorMessage);
                });

        log.info("Fim da chamada de ConsultarClienteUseCase");

        return response;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClienteResponse> buscarTodos() {

        log.info("Inicio da chamada de ConsultarClienteUseCase");

        List<ClienteResponse> response = repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();

        log.info("Fim da chamada de ConsultarClienteUseCase");

        return response;
    }

}
