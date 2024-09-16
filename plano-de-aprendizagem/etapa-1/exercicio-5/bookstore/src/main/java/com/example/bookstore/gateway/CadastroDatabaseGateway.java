package com.example.bookstore.gateway;

import com.example.bookstore.domain.entity.Livro;
import com.example.bookstore.entrypoint.response.CadastroLivroResponse;

public interface CadastroDatabaseGateway {
    CadastroLivroResponse cadastra(Livro livro);
}
