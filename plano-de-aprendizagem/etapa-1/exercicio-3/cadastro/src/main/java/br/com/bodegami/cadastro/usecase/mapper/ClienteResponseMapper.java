package br.com.bodegami.cadastro.usecase.mapper;

import br.com.bodegami.cadastro.controller.dto.ClienteResponse;
import br.com.bodegami.cadastro.domain.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteResponseMapper {

    ClienteResponse toResponse(Cliente cliente);

}
