package com.onepiece.akumanomi.repository;

import java.util.Optional;

import com.onepiece.akumanomi.model.fruta.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
    Optional<Categoria> findById(Long id);

    Optional<Categoria> findByTipo(String tipo);
}