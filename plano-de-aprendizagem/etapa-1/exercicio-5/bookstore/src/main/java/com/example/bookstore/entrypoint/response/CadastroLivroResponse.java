package com.example.bookstore.entrypoint.response;

public record CadastroLivroResponse(
        String id,
        String titulo,
        String autor,
        String isbn,
        String anoPublicacao
) {
}
