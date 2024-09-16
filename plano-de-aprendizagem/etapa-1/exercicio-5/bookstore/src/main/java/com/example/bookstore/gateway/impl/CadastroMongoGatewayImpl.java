package com.example.bookstore.gateway.impl;

import com.example.bookstore.domain.entity.Livro;
import com.example.bookstore.entrypoint.response.CadastroLivroResponse;
import com.example.bookstore.gateway.CadastroDatabaseGateway;
import com.example.bookstore.gateway.client.LivroRepository;
import com.example.bookstore.usecase.mapper.LivroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CadastroMongoGatewayImpl implements CadastroDatabaseGateway {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private LivroMapper livroMapper;

    @Override
    public CadastroLivroResponse cadastra(Livro livro) {

        livro = livroRepository.save(livro);
        CadastroLivroResponse response = livroMapper.toResponse(livro);

        return response;
    }
}
