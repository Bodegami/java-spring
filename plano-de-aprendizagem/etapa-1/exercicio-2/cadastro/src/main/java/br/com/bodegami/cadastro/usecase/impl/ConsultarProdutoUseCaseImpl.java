package br.com.bodegami.cadastro.usecase.impl;

import br.com.bodegami.cadastro.config.exception.ResourceNotFoundException;
import br.com.bodegami.cadastro.entrypoint.dto.ProdutoResponse;
import br.com.bodegami.cadastro.externalprovider.database.ProdutoRepository;
import br.com.bodegami.cadastro.usecase.ConsultarProdutoUseCase;
import br.com.bodegami.cadastro.usecase.mapper.ProdutoResponseMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ConsultarProdutoUseCaseImpl implements ConsultarProdutoUseCase {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoResponseMapper mapper;

    @Transactional(readOnly = true)
    @Override
    public ProdutoResponse consultarPorId(Long id) {

        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("ID %s not found!", id)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProdutoResponse> consultarTodosProdutos() {

        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }
}
