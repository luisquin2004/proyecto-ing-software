package com.asociados.wayne.service.impl;

import com.asociados.wayne.model.Usuario;
import com.asociados.wayne.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl{

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public void register(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario authenticate(String correo, String password) {
        return usuarioRepository.findByCorreoAndPassword(correo, password)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials"));
    }

}
