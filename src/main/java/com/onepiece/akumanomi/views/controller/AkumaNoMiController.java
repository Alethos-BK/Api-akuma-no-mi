package com.onepiece.akumanomi.views.controller;

import java.util.List;
import java.util.Optional;

import com.onepiece.akumanomi.model.fruta.AkumaNoMi;
import com.onepiece.akumanomi.service.fruta.AkumaNoMiService;
import com.onepiece.akumanomi.shared.AkumaNoMiDto;

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
@RequestMapping(value = "/api/fruta")
public class AkumaNoMiController {
    
    @Autowired AkumaNoMiService _frutaService;

    @GetMapping
    public ResponseEntity<List<AkumaNoMiDto>> obterTodos(){
        
        if(_frutaService.obterTodos().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(_frutaService.obterTodos(), HttpStatus.OK);
    }

       
    @GetMapping("/{nome}")
    public ResponseEntity<AkumaNoMiDto> obterPorNome(@PathVariable String nome){

        Optional<AkumaNoMiDto> categoria = _frutaService.obterPorNome(nome);
    
        if(categoria.isPresent()){
            return new ResponseEntity<>(
                new ModelMapper().map(categoria.get(), AkumaNoMiDto.class),
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("categoria/{tipo}")
    public ResponseEntity<List<AkumaNoMiDto>> obterporCategoria(@PathVariable Long tipo){

        if(_frutaService.obterPorCategoria(tipo).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(_frutaService.obterPorCategoria(tipo), HttpStatus.OK);
    }

    @PostMapping("/{categoriaId}")
    public ResponseEntity<AkumaNoMiDto> cadastrarCategoria(@RequestBody AkumaNoMiDto fruta, @PathVariable Long categoriaId) throws Exception{
        AkumaNoMiDto cadastrarFruta = _frutaService.cadastrarAkumaNoMi(fruta, categoriaId);

        return new ResponseEntity<>(cadastrarFruta, HttpStatus.CREATED);
    }

    @PutMapping(value="{id}")
    public ResponseEntity<AkumaNoMiDto> atualizarCategoria(@PathVariable Long id, @RequestBody AkumaNoMi user, String categ){
         ModelMapper mapper = new ModelMapper();
            
        AkumaNoMiDto atualizarCateg = mapper.map(user, AkumaNoMiDto.class);

        return new ResponseEntity<>(_frutaService.atualizarAkumaNoMi(id, atualizarCateg, categ),
            HttpStatus.OK);
        }

        @DeleteMapping(value="{id}")
        public ResponseEntity<Void> removerUsuario(@PathVariable Long id){
            _frutaService.removerAkumaNoMi(id);
    
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
