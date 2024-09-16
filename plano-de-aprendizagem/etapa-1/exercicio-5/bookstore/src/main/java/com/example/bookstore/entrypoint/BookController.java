package com.example.bookstore.entrypoint;

import com.example.bookstore.entrypoint.request.CadastroLivroRequest;
import com.example.bookstore.entrypoint.response.CadastroLivroResponse;
import com.example.bookstore.usecase.CadastrarLivroUseCase;
import com.example.bookstore.usecase.mapper.LivroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private CadastrarLivroUseCase cadastrarLivroUseCase;

    @Autowired
    private LivroMapper livroMapper;

    @PostMapping
    public ResponseEntity<CadastroLivroResponse> cadastrar(@RequestBody CadastroLivroRequest request) {

        var livro = livroMapper.toDomain(request);

        CadastroLivroResponse response = cadastrarLivroUseCase.cadastra(livro);

        URI uri = UriComponentsBuilder.fromPath("/books/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }



}
