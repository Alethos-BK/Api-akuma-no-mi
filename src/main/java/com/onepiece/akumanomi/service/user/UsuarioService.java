package com.onepiece.akumanomi.service.user;

import java.util.List;
import java.util.Optional;

import com.onepiece.akumanomi.shared.UsuarioDto;
import com.onepiece.akumanomi.shared.login.LoginResponse;

public interface UsuarioService {

    List<UsuarioDto> obterTodos();
    Optional<UsuarioDto> obterPorNome(String user);
    UsuarioDto cadastarUsuario(UsuarioDto usuario);
    UsuarioDto atualizaUsuario(Long id, UsuarioDto usuario);
    void removerUsuaro(Long id);
    LoginResponse logar(String usuario, String senha) throws Exception;
}
