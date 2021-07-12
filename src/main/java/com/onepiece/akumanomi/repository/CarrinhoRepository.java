package com.onepiece.akumanomi.repository;

import java.util.Optional;

import com.onepiece.akumanomi.model.Carrinho;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{
    
    Optional<Carrinho> findById(Long id);
}
