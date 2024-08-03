package br.com.bodegami.cadastro.entrypoint.dto;

import br.com.bodegami.cadastro.domain.Usuario;
import jakarta.validation.constraints.*;

public class CadastroUsuarioRequest {

    @NotNull
    @Size(max = 50, min = 10)
    private String nome;

    @Email
    @NotNull
    @Size(min = 10, max = 50)
    private String email;

    @NotNull
    @Size(max = 50, min = 8)
    private String senha;

    @Deprecated
    //Hibernate Only
    public CadastroUsuarioRequest() {
    }

    public CadastroUsuarioRequest(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public @NotNull @Size(max = 50, min = 10) String getNome() {
        return nome;
    }

    public void setNome(@NotNull @Size(max = 50, min = 10) String nome) {
        this.nome = nome;
    }

    public @Email @NotNull @Size(min = 10, max = 50) String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotNull @Size(min = 10, max = 50) String email) {
        this.email = email;
    }

    public @NotNull @Size(max = 50, min = 8) String getSenha() {
        return senha;
    }

    public void setSenha(@NotNull @Size(max = 50, min = 8) String senha) {
        this.senha = senha;
    }

    public Usuario toDomain(CadastroUsuarioRequest request) {
        return new Usuario(nome, email, senha);
    }
}
