package com.onepiece.akumanomi.repository;

import java.util.Optional;

import com.onepiece.akumanomi.model.fruta.AkumaNoMi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AkumaNoMiRepository  extends JpaRepository<AkumaNoMi, Long>{
    
    Optional<AkumaNoMi> findById(Long id);

    Optional<AkumaNoMi> findByNome(String nome);

}