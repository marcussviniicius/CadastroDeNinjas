package dev.java10x.CadastroDeNinjas.repository;

import dev.java10x.CadastroDeNinjas.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, String> {

    Optional<UsuarioModel> findByUsername(String username);
}
