package br.com.bodegami.cadastro.usecase.mapper;

import br.com.bodegami.cadastro.domain.Produto;
import br.com.bodegami.cadastro.entrypoint.dto.ProdutoResponse;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProdutoResponseMapper {

    ProdutoResponse toResponse(Produto produto);

}
