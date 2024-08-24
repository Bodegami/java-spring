package com.example.demo.application.mapper;

import com.example.demo.domain.entity.Tarefa;
import com.example.demo.infra.controller.dto.TarefaRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "titulo", source = "titulo")
    @Mapping(target = "descricao", source = "descricao")
    @Mapping(target = "dataCriacao", qualifiedByName = "getDataConclusao")
    @Mapping(target = "dataConclusao", qualifiedByName = "getDataConclusao")
    Tarefa toDomain(TarefaRequest request);

    @Named("getDataConclusao")
    default String getDataConclusao(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return LocalDateTime.parse(data).format(formatter);
    }

}
