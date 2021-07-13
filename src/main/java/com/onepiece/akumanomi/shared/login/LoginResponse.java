package com.onepiece.akumanomi.shared.login;

import com.onepiece.akumanomi.model.usuario.Usuario;

public class LoginResponse {
    
    private String token;

    private Usuario usuario;

    public LoginResponse(String token, Usuario usuario) {
        this.token = token;
        this.usuario = usuario;
    }

    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setusuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
