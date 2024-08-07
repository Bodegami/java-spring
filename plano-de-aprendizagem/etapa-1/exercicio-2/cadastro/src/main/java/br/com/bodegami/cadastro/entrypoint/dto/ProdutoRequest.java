package br.com.bodegami.cadastro.entrypoint.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequest {

    @NotNull
    private String nome;

    @NotNull
    @Size(min = 10, max = 250)
    private String descricao;

    @Positive
    @NotNull
    private BigDecimal preco;

    @Positive
    @NotNull
    private Integer quantidadeEmEstoque;

}
