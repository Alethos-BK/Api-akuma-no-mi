package com.onepiece.akumanomi.shared;

public class UsuarioDto {
    
    private Long id;

    private String nome;

    private String usuario;

    private String senha;
    
    public UsuarioDto() {
    }

    public UsuarioDto(String nome, String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public UsuarioDto(Long id, String nome,String usuario, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
