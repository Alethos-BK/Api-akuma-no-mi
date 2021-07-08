package com.onepiece.akumanomi.service.fruta;

import java.util.List;
import java.util.Optional;

import com.onepiece.akumanomi.shared.AkumaNoMiDto;

public interface AkumaNoMiService {

    List<AkumaNoMiDto> obterTodos();
    Optional<AkumaNoMiDto> obterPorNome(String nome);
    List<AkumaNoMiDto> obterPorCategoria(Long idCategoria);
    AkumaNoMiDto cadastrarAkumaNoMi(AkumaNoMiDto fruta, Long categoria) throws Exception;
    AkumaNoMiDto atualizarAkumaNoMi(Long id, AkumaNoMiDto fruta, Long idCategoria);
    void removerAkumaNoMi(Long id);
    

}
