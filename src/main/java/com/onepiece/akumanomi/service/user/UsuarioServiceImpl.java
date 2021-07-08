package com.onepiece.akumanomi.service.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.onepiece.akumanomi.model.usuario.Usuario;
import com.onepiece.akumanomi.repository.UsuarioRepository;
import com.onepiece.akumanomi.shared.UsuarioDto;
import com.onepiece.akumanomi.shared.login.LoginResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioRepository _userRepository;

    @Override
    public List<UsuarioDto> obterTodos(){
        List<Usuario> usuarios = _userRepository.findAll();

        return usuarios.stream().map(user -> new ModelMapper().map(user, UsuarioDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<UsuarioDto> obterPorNome(String user){
        Optional<Usuario> usuario = _userRepository.findByUsuario(user);

        if(usuario.isPresent()){
            return Optional.of(new ModelMapper().map(usuario.get(), UsuarioDto.class));
        }
        return Optional.empty();
    }

    @Override
    public UsuarioDto cadastarUsuario(UsuarioDto usuario){
        return salvarUser(usuario);
    }

    @Override
    public UsuarioDto atualizaUsuario(Long id, UsuarioDto usuario){
        usuario.setId(id);

        return salvarUser(usuario);
    }

    @Override
    public void removerUsuaro(Long id){
        _userRepository.deleteById(id);
    }

    @Override
    public LoginResponse logar(String usuario, String senha) throws Exception{

        var user = _userRepository.findByUsuario(usuario);

        if(user.get().getSenha().equals(senha)){
            return new LoginResponse(user.get());
        } else {
            throw new Exception("Senha inválidos :(");
        }

         
    }

    private UsuarioDto salvarUser(UsuarioDto usuario) {
        ModelMapper mapper = new ModelMapper();
        Usuario userEntity = mapper.map(usuario, Usuario.class);
        userEntity = _userRepository.save(userEntity);

        return mapper.map(userEntity, UsuarioDto.class);
    }
}
