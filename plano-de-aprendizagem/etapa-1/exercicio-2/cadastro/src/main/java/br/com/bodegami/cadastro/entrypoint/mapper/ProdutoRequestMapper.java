package br.com.bodegami.cadastro.entrypoint.mapper;

import br.com.bodegami.cadastro.domain.Produto;
import br.com.bodegami.cadastro.entrypoint.dto.ProdutoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoRequestMapper {

    @Mapping(target = "id", ignore = true)
    Produto toDomain(ProdutoRequest request);

}
