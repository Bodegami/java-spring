package com.example.bookstore.usecase;

import com.example.bookstore.domain.entity.Livro;
import com.example.bookstore.entrypoint.response.CadastroLivroResponse;

public interface CadastrarLivroUseCase {
    CadastroLivroResponse cadastra(Livro livro);
}
