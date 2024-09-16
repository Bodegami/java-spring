package com.example.bookstore.domain.entity;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "livro")
public class Livro {

    @Id
    private String id;
    private String titulo;
    private String autor;
    private String isbn;
    private String anoPublicacao;

}
