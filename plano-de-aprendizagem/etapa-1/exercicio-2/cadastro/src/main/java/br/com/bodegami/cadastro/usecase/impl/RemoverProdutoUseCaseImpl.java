package br.com.bodegami.cadastro.usecase.impl;

import br.com.bodegami.cadastro.externalprovider.database.ProdutoRepository;
import br.com.bodegami.cadastro.usecase.RemoverProdutoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RemoverProdutoUseCaseImpl implements RemoverProdutoUseCase {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    @Override
    public void deletarPorId(Long id) {

        repository.deleteById(id);
    }
}
