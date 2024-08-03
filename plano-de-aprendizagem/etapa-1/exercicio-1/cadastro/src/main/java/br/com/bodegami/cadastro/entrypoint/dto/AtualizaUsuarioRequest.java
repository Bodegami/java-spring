package br.com.bodegami.cadastro.entrypoint.dto;

import br.com.bodegami.cadastro.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class AtualizaUsuarioRequest {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Size(max = 50, min = 10)
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Email
    @Size(max = 50, min = 10)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Size(max = 50, min = 8)
    private String senha;

    @Deprecated
    //Hibernate Only
    public AtualizaUsuarioRequest() {
    }

    public AtualizaUsuarioRequest(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario toDomain(AtualizaUsuarioRequest request) {
        return new Usuario(request.getNome(), request.getEmail(), request.getSenha());
    }
}
