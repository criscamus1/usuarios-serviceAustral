package com.example.usuariosAustral.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.usuariosAustral.model.Usuario;
import java.util.Optional;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
List<Usuario> findByRolIgnoreCase(String rol);
Optional<Usuario> findByCorreo(String correo);
boolean existsByCorreo(String correo);

}
