package com.onepiece.akumanomi.shared.login;

import com.onepiece.akumanomi.model.usuario.Usuario;

public class LoginResponse {
    
    private Usuario usuario;

    public LoginResponse(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setusuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
