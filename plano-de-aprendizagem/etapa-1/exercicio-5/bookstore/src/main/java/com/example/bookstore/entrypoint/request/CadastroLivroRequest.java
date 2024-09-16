package com.example.bookstore.entrypoint.request;

public record CadastroLivroRequest(
        String titulo,
        String autor,
        String isbn,
        String anoPublicacao
) {
}
