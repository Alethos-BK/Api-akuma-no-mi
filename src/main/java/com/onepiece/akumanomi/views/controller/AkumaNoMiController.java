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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api(value = "API REST loja virtual de Akumas no Mi")
@RestController
@RequestMapping(value = "/api/fruta")
public class AkumaNoMiController {
    
    @Autowired 
    AkumaNoMiService _frutaService;

    

    @ApiOperation("Retorna todas as Akumas no Mi")
    @GetMapping
    public ResponseEntity<List<AkumaNoMi>> obterTodos(
        @RequestParam(required = false) Integer pagina,
	    @RequestParam(required = false) Integer qtdRegistros
    ){
        
        if(_frutaService.obterTodos(pagina, qtdRegistros).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(_frutaService.obterTodos(pagina, qtdRegistros), HttpStatus.OK);
    }

    @ApiOperation("Retorna Akumas no Mi por nome")
    @GetMapping("nome/{nome}")
    public ResponseEntity<List<AkumaNoMi>> obterPorNome(@PathVariable(value= "nome") String nome) throws Exception{

        List<AkumaNoMi> categoria = _frutaService.obterPorNome(nome);
    
        if(categoria.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        };

        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @ApiOperation("Retorna Akumas no Mi por tipo")
    @GetMapping("categoria/{tipo}")
    public ResponseEntity<List<AkumaNoMi>> obterporCategoria(
        @PathVariable Long tipo,
        @RequestParam(required = false) Integer pagina,
		@RequestParam(required = false) Integer qtdRegistros)
    {

        if(_frutaService.obterPorCategoria(tipo, pagina, qtdRegistros).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(_frutaService.obterPorCategoria(tipo, pagina, qtdRegistros), HttpStatus.OK);
    }

    @ApiOperation("Adiciona uma nova Akuma no Mi")
    @PostMapping("/{categoriaId}")
    public ResponseEntity<AkumaNoMi> cadastrarCategoria(@RequestBody AkumaNoMiDto fruta, @PathVariable Long categoriaId) throws Exception{
        AkumaNoMi cadastrarFruta = _frutaService.cadastrarAkumaNoMi(fruta, categoriaId);

        return new ResponseEntity<>(cadastrarFruta, HttpStatus.CREATED);
    }

    @ApiOperation("Atualiza uma Akuma no Mi por id")
    @PutMapping(value="{id}")
    public ResponseEntity<AkumaNoMi> atualizarCategoria(@PathVariable Long id, @RequestBody AkumaNoMi user) throws Exception{
        
         ModelMapper mapper = new ModelMapper();
            
        AkumaNoMiDto att = mapper.map(user, AkumaNoMiDto.class);

        return new ResponseEntity<>(_frutaService.atualizarAkumaNoMi(id, att),
            HttpStatus.OK);
        }

    @ApiOperation("Deleta uma Akuma no MI")
    @DeleteMapping(value="{id}")
        public ResponseEntity<Void> removerUsuario(@PathVariable Long id){
            _frutaService.removerAkumaNoMi(id);
    
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
