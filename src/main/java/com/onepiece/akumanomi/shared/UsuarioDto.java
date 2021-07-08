package com.onepiece.akumanomi.shared;

public class UsuarioDto {
    
    private Long id;

    private String usuario;

    private String senha;
    
    public UsuarioDto() {
    }

    public UsuarioDto(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public UsuarioDto(Long id, String usuario, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Long getId() {
        return id;
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
