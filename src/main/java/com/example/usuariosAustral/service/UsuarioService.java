package com.example.usuariosAustral.service;

import com.example.usuariosAustral.Exception.ExceptionUser;
import com.example.usuariosAustral.dto.CreateUsuarioRequest;
import com.example.usuariosAustral.model.Usuario;
import com.example.usuariosAustral.repository.UsuarioRepository;
import com.example.usuariosAustral.dto.ActualizarUsuario;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
 @Autowired
 private UsuarioRepository repository;

 public List<Usuario> getAllRecursos(){
   return repository.findAll();
 }
    public Usuario buscarUsuario(int id){ 
        return repository.findById(id)
                .orElseThrow(() -> new ExceptionUser("El usuario no fue encontrado"));
    }
public List<Usuario> buscarPorRol(String rol){
    return repository.findByRol(rol);
}

public Usuario guardarUsuario(CreateUsuarioRequest dto) {
    if (repository.existsByCorreo(dto.correo())) {
        throw new ExceptionUser("Ya existe un usuario con ese correo.");
    }
    Usuario usuario = new Usuario();
    usuario.setNombre(dto.nombre());
    usuario.setCorreo(dto.correo());
    usuario.setTelefono(dto.telefono());
    usuario.setRol(dto.rol());
    return repository.save(usuario);
}
public Usuario actualizarUsuario(int id, ActualizarUsuario dto) {
    Usuario usuario = buscarUsuario(id);
    Optional<Usuario> existente = repository.findByCorreo(dto.correo());
    if (existente.isPresent() && existente.get().getId() != id) {
        throw new ExceptionUser("Ya existe un usuario con ese correo.");
    }
    usuario.setNombre(dto.nombre());
    usuario.setCorreo(dto.correo());
    usuario.setTelefono(dto.telefono());
    usuario.setRol(dto.rol());
    return repository.save(usuario);
}
public void eliminarUsuario(int id){
   Usuario usuario=buscarUsuario(id);
   repository.delete(usuario);
}

}
