package br.com.bodegami.cadastro.usecase.impl;

import br.com.bodegami.cadastro.controller.dto.ClienteResponse;
import br.com.bodegami.cadastro.domain.Cliente;
import br.com.bodegami.cadastro.gateway.ClienteRepository;
import br.com.bodegami.cadastro.usecase.AtualizarClienteUseCase;
import br.com.bodegami.cadastro.usecase.mapper.ClienteResponseMapper;
import br.com.bodegami.cadastro.utils.exception.UpdateUserIntegrityViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class AtualizarClienteUseCaseImpl implements AtualizarClienteUseCase {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteResponseMapper mapper;

    @Transactional
    @Override
    public ClienteResponse atualizar(Long id, Cliente request) {

        log.info("Inicio da chamada de AtualizarClienteUseCase");

        var cliente = repository.getReferenceById(id);

        if (!request.getCpf().equalsIgnoreCase(cliente.getCpf())) {
            String errorMessage = String.format("O ID: %d - Não pertence ao CPF: %s", id, request.getCpf());

            log.info(String.format("Error na chamada de AtualizarClienteUseCase | Error: %s", errorMessage));
            throw new UpdateUserIntegrityViolationException(errorMessage);
        }

        request.setId(id);

        Cliente response = repository.save(request);

        log.info("Fim da chamada de AtualizarClienteUseCase");

        return mapper.toResponse(response);
    }
}
