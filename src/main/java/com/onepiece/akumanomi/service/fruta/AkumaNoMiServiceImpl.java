package com.onepiece.akumanomi.service.fruta;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.onepiece.akumanomi.model.fruta.AkumaNoMi;
import com.onepiece.akumanomi.model.fruta.Categoria;
import com.onepiece.akumanomi.repository.AkumaNoMiRepository;
import com.onepiece.akumanomi.repository.CategoriaRepository;
import com.onepiece.akumanomi.shared.AkumaNoMiDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AkumaNoMiServiceImpl implements AkumaNoMiService{
    
    @Autowired AkumaNoMiRepository _akumaRepository;

    @Autowired CategoriaRepository _categoriaRepository;

    @Override
    public List<AkumaNoMiDto> obterTodos(){
        List<AkumaNoMi> frutas = _akumaRepository.findAll();

        return frutas.stream().map(categoria -> new ModelMapper().map(categoria, AkumaNoMiDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<AkumaNoMiDto> obterPorNome(String nome){
        Optional<AkumaNoMi> nomesAkumas = _akumaRepository.findByNome(nome);

        if(nomesAkumas.isPresent()){
            return Optional.of(new ModelMapper().map(nomesAkumas.get(), AkumaNoMiDto.class));
        }
        return Optional.empty();
    }

    @Override
    public List<AkumaNoMiDto> obterPorCategoria(Long idCategoria){

        List<AkumaNoMiDto> frutas = new ArrayList<>();

        var todasAsFrutas = obterTodos();

        for (AkumaNoMiDto fruta : todasAsFrutas) {
            if(fruta.getCategoria().getId() == idCategoria){
                frutas.add(fruta);
            }
        }

        return frutas;
    }

    @Override
    public AkumaNoMiDto cadastrarAkumaNoMi(AkumaNoMiDto fruta, Long categoria) throws Exception{
        
        Optional<Categoria> categ = _categoriaRepository.findById(categoria);

        if(categ.isPresent()) {
           
            fruta.setCategoriaId(categ.get());
            
        } else {
            throw new Exception("Categoria inexistente");
        }
      
        return salvarAkumaNoMi(fruta);
    }

    @Override
    public AkumaNoMiDto atualizarAkumaNoMi(Long id, AkumaNoMiDto fruta, String nomeCategoria){
        
        fruta.setId(id);

        Optional<Categoria> categoria = _categoriaRepository.findByTipo(nomeCategoria);

        if(categoria.isPresent()){
			fruta.setCategoriaId(categoria.get());
		} else {
			return null;
		}

        return salvarAkumaNoMi(fruta);
    }

    @Override
    public void removerAkumaNoMi(Long id){
        _akumaRepository.deleteById(id);
    }


    private AkumaNoMiDto salvarAkumaNoMi(AkumaNoMiDto fruta) {
        ModelMapper mapper = new ModelMapper();
        AkumaNoMi frutaEntity = mapper.map(fruta, AkumaNoMi.class);
        frutaEntity = _akumaRepository.save(frutaEntity);

        return mapper.map(frutaEntity, AkumaNoMiDto.class);
    }

}