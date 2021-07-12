package com.onepiece.akumanomi.security;

import java.util.Optional;
import java.util.function.Supplier;

import com.onepiece.akumanomi.model.usuario.Usuario;
import com.onepiece.akumanomi.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository _userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String user) {
		Usuario usuario = getUser(() -> _userRepository.findByUsuario(user));
		return (UserDetails) usuario;
	}
	
	public UserDetails pegarUsuarioPorId(Long id) {
		Usuario usuario = getUser(() -> _userRepository.findById(id));
		return (UserDetails) usuario;
	}
	
	
	private Usuario getUser(Supplier<Optional<Usuario>> supplier) {
		return supplier.get().orElseThrow(() -> 
				new UsernameNotFoundException("Usuário não encontrado"));
	}

}
