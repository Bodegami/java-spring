package com.example.bookstore.usecase.impl;

import com.example.bookstore.domain.entity.Livro;
import com.example.bookstore.entrypoint.response.CadastroLivroResponse;
import com.example.bookstore.gateway.CadastroDatabaseGateway;
import com.example.bookstore.usecase.CadastrarLivroUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastrarLivroUseCaseImpl implements CadastrarLivroUseCase {

    @Autowired
    private CadastroDatabaseGateway cadastroDatabaseGateway;

    @Override
    public CadastroLivroResponse cadastra(Livro livro) {

        var response = cadastroDatabaseGateway.cadastra(livro);

        return response;
    }
}
