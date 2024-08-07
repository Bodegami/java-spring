package br.com.bodegami.cadastro.usecase.impl;

import br.com.bodegami.cadastro.externalprovider.database.ProdutoRepository;
import br.com.bodegami.cadastro.domain.Produto;
import br.com.bodegami.cadastro.entrypoint.dto.ProdutoResponse;
import br.com.bodegami.cadastro.usecase.CadastrarProdutoUseCase;
import br.com.bodegami.cadastro.usecase.mapper.ProdutoResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CadastrarProdutoUseCaseImpl implements CadastrarProdutoUseCase {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoResponseMapper mapper;

    @Transactional
    @Override
    public ProdutoResponse cadastrar(Produto request) {

        Produto produto = repository.save(request);
        ProdutoResponse response = mapper.toResponse(produto);

        return response;
    }


}
