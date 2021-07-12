package com.onepiece.akumanomi.views.controller;

import java.util.List;

import com.onepiece.akumanomi.model.Carrinho;
import com.onepiece.akumanomi.service.CarrinhoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api
@RestController
@RequestMapping("/api/pedidos")
public class CarrinhoController {
    
    @Autowired
    private CarrinhoService _serviceCarrinho;

    @ApiOperation("Obter todos os pedidos")
    @GetMapping
    public ResponseEntity<List<Carrinho>> obterTodos(){
        return new ResponseEntity<>(_serviceCarrinho.obterTodos(), HttpStatus.OK);
    }

    @ApiOperation("Cadastrar um pedido")
    @PostMapping
    public ResponseEntity<Carrinho> criarPedido(@RequestBody Carrinho carrinho){
        return new ResponseEntity<>(_serviceCarrinho.criarPedido(carrinho), HttpStatus.CREATED);
    }

}
