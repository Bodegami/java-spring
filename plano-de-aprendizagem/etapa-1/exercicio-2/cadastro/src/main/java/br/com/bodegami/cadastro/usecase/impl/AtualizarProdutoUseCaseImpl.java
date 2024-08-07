package br.com.bodegami.cadastro.usecase.impl;

import br.com.bodegami.cadastro.config.exception.ResourceNotFoundException;
import br.com.bodegami.cadastro.domain.Produto;
import br.com.bodegami.cadastro.entrypoint.dto.ProdutoResponse;
import br.com.bodegami.cadastro.externalprovider.database.ProdutoRepository;
import br.com.bodegami.cadastro.usecase.AtualizarProdutoUseCase;
import br.com.bodegami.cadastro.usecase.mapper.ProdutoResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AtualizarProdutoUseCaseImpl implements AtualizarProdutoUseCase {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoResponseMapper mapper;

    @Transactional
    @Override
    public ProdutoResponse atualizaProduto(Long id, Produto request) {

        boolean isValidProductId = repository.existsById(id);

        if (!isValidProductId) {
            throw new ResourceNotFoundException(String.format("ID %s not found!", id));
        }

        request.setId(id);
        Produto response = repository.save(request);

        return mapper.toResponse(response);
    }
}
