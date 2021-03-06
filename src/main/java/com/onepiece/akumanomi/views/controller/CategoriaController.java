package com.onepiece.akumanomi.views.controller;

import java.util.List;
import java.util.Optional;

import com.onepiece.akumanomi.model.fruta.Categoria;
import com.onepiece.akumanomi.service.fruta.CategoriaService;
import com.onepiece.akumanomi.shared.CategoriaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api(value = "API REST loja virtual de Akumas no Mi")
@RestController
@RequestMapping(value = "/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService _categoriaService;

    @ApiOperation("Retorna todos as categorias de Akuma no MI")
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> obterTodos(){
        
        if(_categoriaService.obterTodos().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(_categoriaService.obterTodos(), HttpStatus.OK);
    }

    @ApiOperation("Restorna uma categoria de Akuma no Mi por nome")
    @GetMapping("/{tipoCateg}")
    public ResponseEntity<CategoriaDto> obterPorNome(@PathVariable String tipoCateg){

        Optional<CategoriaDto> categoria = _categoriaService.obterPorNome(tipoCateg);
    
        if(categoria.isPresent()){
            return new ResponseEntity<>(
                new ModelMapper().map(categoria.get(), CategoriaDto.class),
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation("Cadastra uma nova categoria de Akuma no Mi")
    @PostMapping
    public ResponseEntity<CategoriaDto> cadastrarCategoria(@RequestBody CategoriaDto categoria){
        CategoriaDto cadastrarCateg = _categoriaService.cadastrarCategoria(categoria);

        return new ResponseEntity<>(cadastrarCateg, HttpStatus.CREATED);
    }

    @ApiOperation("Atualiza uma categoria de Akuma no Mi por id")
    @PutMapping(value="{id}")
    public ResponseEntity<CategoriaDto> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria user){
         ModelMapper mapper = new ModelMapper();
            
        CategoriaDto atualizarCateg = mapper.map(user, CategoriaDto.class);

        return new ResponseEntity<>(_categoriaService.atualizarCategoria(id, atualizarCateg),
            HttpStatus.OK);
        }

    @ApiOperation("Deleta uma categoria de Akuma no Mi por id")
    @DeleteMapping(value="{id}")
        public ResponseEntity<Void> removerUsuario(@PathVariable Long id){
            _categoriaService.removerCategoria(id);
    
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    
    
}
