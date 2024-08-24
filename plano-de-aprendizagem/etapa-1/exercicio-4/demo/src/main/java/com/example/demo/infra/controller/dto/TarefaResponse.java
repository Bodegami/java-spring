package com.example.demo.infra.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TarefaResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private String dataCriacao;
    private String dataConclusao;

}
