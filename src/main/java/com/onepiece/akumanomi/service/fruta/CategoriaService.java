package com.onepiece.akumanomi.service.fruta;

import java.util.List;
import java.util.Optional;

import com.onepiece.akumanomi.shared.CategoriaDto;

public interface CategoriaService {

    List<CategoriaDto> obterTodos();
    Optional<CategoriaDto> obterPorNome(String tipo);
    CategoriaDto cadastrarCategoria(CategoriaDto categoria);
    CategoriaDto atualizarCategoria(Long id, CategoriaDto categoria);
    void removerCategoria(Long id);
}

