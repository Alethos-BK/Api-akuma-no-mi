package com.onepiece.akumanomi.service.fruta;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.onepiece.akumanomi.model.fruta.Categoria;
import com.onepiece.akumanomi.repository.CategoriaRepository;
import com.onepiece.akumanomi.shared.CategoriaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired CategoriaRepository _categoriaRepository;

    @Override
    public List<CategoriaDto> obterTodos(){
        List<Categoria> categorias = _categoriaRepository.findAll();

        return categorias.stream().map(categoria -> new ModelMapper().map(categoria, CategoriaDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<CategoriaDto> obterPorNome(String tipo){
        Optional<Categoria> tipoCateg = _categoriaRepository.findByTipo(tipo);

        if(tipoCateg.isPresent()){
            return Optional.of(new ModelMapper().map(tipoCateg.get(), CategoriaDto.class));
        }
        return Optional.empty();
    }

    @Override
    public CategoriaDto cadastrarCategoria(CategoriaDto categoria){
        return salvarCategoria(categoria);
    }

    @Override
    public CategoriaDto atualizarCategoria(Long id, CategoriaDto categoria){
        categoria.setId(id);

        return salvarCategoria(categoria);
    }

    @Override
    public void removerCategoria(Long id){
        _categoriaRepository.deleteById(id);
    }

    private CategoriaDto salvarCategoria(CategoriaDto categoria) {
        ModelMapper mapper = new ModelMapper();
        Categoria userEntity = mapper.map(categoria, Categoria.class);
        userEntity = _categoriaRepository.save(userEntity);

        return mapper.map(userEntity, CategoriaDto.class);
    }
}
