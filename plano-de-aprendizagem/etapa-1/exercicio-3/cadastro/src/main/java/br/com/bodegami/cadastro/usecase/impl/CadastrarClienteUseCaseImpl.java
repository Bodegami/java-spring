package br.com.bodegami.cadastro.usecase.impl;

import br.com.bodegami.cadastro.controller.dto.ClienteResponse;
import br.com.bodegami.cadastro.domain.Cliente;
import br.com.bodegami.cadastro.gateway.ClienteRepository;
import br.com.bodegami.cadastro.usecase.CadastrarClienteUseCase;
import br.com.bodegami.cadastro.usecase.mapper.ClienteResponseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class CadastrarClienteUseCaseImpl implements CadastrarClienteUseCase {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteResponseMapper mapper;

    @Transactional
    @Override
    public ClienteResponse cadastrar(Cliente request) {

        log.info("Inicio da chamada de CadastrarClienteUseCase");

        Cliente cliente = repository.save(request);

        ClienteResponse response = mapper.toResponse(cliente);

        log.info("Fim da chamada de CadastrarClienteUseCase", response);

        return response;
    }

}
