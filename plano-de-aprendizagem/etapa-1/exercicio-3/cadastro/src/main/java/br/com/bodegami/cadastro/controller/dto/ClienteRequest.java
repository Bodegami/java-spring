package br.com.bodegami.cadastro.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    @NotNull(message = "Nome não pode ser nulo")
    @NotEmpty(message = "Nome não pode estar vazio")
    @Size(min = 8, max = 50, message = "Nome deve ter entre 8 e 50 caracteres")
    private String nome;

    @NotNull(message = "CPF não pode ser nulo")
    @NotEmpty(message = "CPF não pode estar vazio")
    @CPF(message = "CPF com formato inválido")
    private String cpf;

    @NotNull(message = "Email não pode ser nulo")
    @NotEmpty(message = "Email não pode estar vazio")
    @Email
    private String email;

    @NotNull(message = "Telefone não pode se nulo")
    @NotEmpty(message = "Telefone não pode estar vazio")
    private String telefone;

}
