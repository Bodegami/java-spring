package com.example.bookstore.gateway.client;

import com.example.bookstore.domain.entity.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LivroRepository extends MongoRepository<Livro, String> {

    Optional<Livro> findByTitulo(String titulo);

}
