package com.onepiece.akumanomi.service.fruta;

import java.util.List;
import java.util.Optional;

import com.onepiece.akumanomi.model.fruta.AkumaNoMi;
import com.onepiece.akumanomi.shared.AkumaNoMiDto;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.ui.Model;

public interface AkumaNoMiService {

    List<AkumaNoMi> obterTodos(Integer pagina, Integer qtdRegistros);
    List<AkumaNoMi> obterPorNome(String nome);
    List<AkumaNoMi> obterPorCategoria(Long idCategoria, Integer pagina, Integer qtdRegistros);
    AkumaNoMi cadastrarAkumaNoMi(AkumaNoMiDto fruta, Long categoria) throws Exception;
    AkumaNoMi atualizarAkumaNoMi(Long id, AkumaNoMiDto fruta) throws Exception;
    void removerAkumaNoMi(Long id);
    

}
