package com.onepiece.akumanomi.repository;

import java.util.Optional;

import com.onepiece.akumanomi.model.usuario.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByUsuario(String usuario);
}
