package br.com.bodegami.cadastro.controller.mapper;

import br.com.bodegami.cadastro.controller.dto.ClienteRequest;
import br.com.bodegami.cadastro.domain.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteRequestMapper {

    Cliente toDomain(ClienteRequest request);

}
