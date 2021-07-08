package com.onepiece.akumanomi.views.controller;

import java.util.List;
import java.util.Optional;

import com.onepiece.akumanomi.model.usuario.Usuario;
import com.onepiece.akumanomi.service.user.UsuarioService;
import com.onepiece.akumanomi.shared.UsuarioDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UsuarioController {
    
    @Autowired UsuarioService _userService;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> obterTodos(){
        
        if(_userService.obterTodos().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(_userService.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/usuario/{user}")
    public ResponseEntity<UsuarioDto> obterPorNome(@PathVariable String user){

        Optional<UsuarioDto> usuario = _userService.obterPorNome(user);
    
        if(usuario.isPresent()){
            return new ResponseEntity<>(
                new ModelMapper().map(usuario.get(), UsuarioDto.class),
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody UsuarioDto user){
        UsuarioDto cadastrarUser = _userService.cadastarUsuario(user);

        return new ResponseEntity<>(cadastrarUser, HttpStatus.CREATED);
    }

    @PutMapping(value="{id}")
    public ResponseEntity<UsuarioDto> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario user){
        ModelMapper mapper = new ModelMapper();
            
        UsuarioDto atualizarUser = mapper.map(user, UsuarioDto.class);

        return new ResponseEntity<>(_userService.atualizaUsuario(id, atualizarUser),
            HttpStatus.OK);
        }
    
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> removerUsuario(@PathVariable Long id){
        _userService.removerUsuaro(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    

}
