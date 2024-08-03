package br.com.bodegami.cadastro.entrypoint.dto;

import br.com.bodegami.cadastro.domain.Usuario;

public class UsuarioResponse {

    private Long id;
    private String nome;
    private String email;

    @Deprecated
    //Hibernate Only
    public UsuarioResponse() {
    }

    public UsuarioResponse(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
