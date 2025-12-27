package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.model.UsuarioModel;
import dev.java10x.CadastroDeNinjas.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioModel registerUser(String username, String password) {
        String senhaCriptografada = passwordEncoder.encode(password);
        UsuarioModel usuario = new UsuarioModel(username, senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}

