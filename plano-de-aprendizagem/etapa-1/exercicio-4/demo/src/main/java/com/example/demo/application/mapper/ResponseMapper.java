package com.example.demo.application.mapper;

import com.example.demo.domain.entity.Tarefa;
import com.example.demo.infra.controller.dto.TarefaResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponseMapper {

    TarefaResponse toResponse(Tarefa tarefa);
}
