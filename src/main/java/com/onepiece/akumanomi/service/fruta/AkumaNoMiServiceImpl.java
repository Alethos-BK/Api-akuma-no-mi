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
import com.onepiece.akumanomi.shared.CategoriaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class AkumaNoMiServiceImpl implements AkumaNoMiService{
    
    @Autowired AkumaNoMiRepository _akumaRepository;

    @Autowired CategoriaRepository _categoriaRepository;

    @Override
    public List<AkumaNoMi> obterTodos(Integer pagina, Integer qtdRegistros){

        Pageable page = null;

        page = PageRequest.of(pagina, qtdRegistros);
        List<AkumaNoMi> frutas = _akumaRepository.findAll(page).getContent();

        return frutas;
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
    public List<AkumaNoMi> obterPorCategoria(Long idCategoria, Integer pagina, Integer qtdRegistros){

        List<AkumaNoMi> frutas = new ArrayList<>();

        List<AkumaNoMi> todasAsFrutas = obterTodos(pagina, qtdRegistros);

        for (AkumaNoMi fruta : todasAsFrutas) {
            if(fruta.getCategoria().getId() == idCategoria){
                frutas.add(fruta);
            }
        }

        return frutas;
    }

    @Override
    public AkumaNoMi cadastrarAkumaNoMi(AkumaNoMiDto fruta, Long categoria) throws Exception{
        
        Optional<Categoria> categ = _categoriaRepository.findById(categoria);
     
        if(categ.isPresent()){    
            return salvarAkumaNoMi(fruta, categ.get());
        } 
        else{
           throw new Exception("Categoria inexistente");
            
        }
    }

    @Override
    public AkumaNoMi atualizarAkumaNoMi(Long id, AkumaNoMiDto fruta) throws Exception {
        
        fruta.setId(id);

        // Optional<Categoria> categoria = _categoriaRepository.findById(idCategoria);

        ModelMapper mapper = new ModelMapper();
        AkumaNoMi frutaEntity = mapper.map(fruta, AkumaNoMi.class);

        return mapper.map(frutaEntity, AkumaNoMi.class);

    }

    @Override
    public void removerAkumaNoMi(Long id){
        _akumaRepository.deleteById(id);
    }


    private AkumaNoMi salvarAkumaNoMi(AkumaNoMiDto fruta, Categoria categoria) {
        ModelMapper mapper = new ModelMapper();
        AkumaNoMi frutaEntity = mapper.map(fruta, AkumaNoMi.class);      
        // CategoriaDto categEntity = mapper.map(categoria, CategoriaDto.class);
        frutaEntity.setCategoriaId(categoria);
        frutaEntity.getCategoria().setTipo(categoria.getTipo());
        frutaEntity.getCategoria().setDescricao(categoria.getDescricao());
        frutaEntity = _akumaRepository.save(frutaEntity);


        return mapper.map(frutaEntity, AkumaNoMi.class);
    }

}
