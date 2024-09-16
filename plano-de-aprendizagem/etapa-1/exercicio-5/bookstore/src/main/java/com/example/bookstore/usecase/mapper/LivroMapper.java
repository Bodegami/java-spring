package com.example.bookstore.usecase.mapper;

import com.example.bookstore.domain.entity.Livro;
import com.example.bookstore.entrypoint.request.CadastroLivroRequest;
import com.example.bookstore.entrypoint.response.CadastroLivroResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LivroMapper {

    @Mapping(target = "id", ignore = true)
    Livro toDomain(CadastroLivroRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "titulo", source = "titulo")
    @Mapping(target = "autor", source = "autor")
    @Mapping(target = "isbn", source = "isbn")
    @Mapping(target = "anoPublicacao", source = "anoPublicacao")
    CadastroLivroResponse toResponse(Livro livro);
}
