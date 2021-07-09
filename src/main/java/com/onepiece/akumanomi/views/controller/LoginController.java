package com.onepiece.akumanomi.views.controller;

import com.onepiece.akumanomi.service.user.UsuarioService;
import com.onepiece.akumanomi.shared.login.LoginRequest;
import com.onepiece.akumanomi.shared.login.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api(value = "API REST loja virtual de Akumas no Mi")
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private UsuarioService _userService;

    @ApiOperation("Fazer login")
    @PostMapping
    public LoginResponse login (@RequestBody LoginRequest request) throws Exception {
        return _userService.logar(request.getUsuario(), request.getSenha());
    }
}
