package com.example.demo.infra.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TarefaRequest {

    @NotNull
    @NotBlank
    private String titulo;

    @NotNull
    @NotBlank
    private String descricao;

    @NotNull
    @NotBlank
    private String dataCriacao = LocalDateTime.now().toString();

    @NotNull
    @NotBlank
    private String dataConclusao;

}
