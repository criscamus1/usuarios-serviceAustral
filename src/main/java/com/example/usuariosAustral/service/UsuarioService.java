package com.example.usuariosAustral.service;

import com.example.usuariosAustral.model.Usuario;
import com.example.usuariosAustral.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
 @Autowired
 private UsuarioRepository repository;


 public List<Usuario>obtenerUsuario(){
    return repository.obtenerUsuario();
 }
 public Usuario buscarUsuario(int id){
    return repository.buscarUsuarioPorId(id);
 }
 public Usuario guardarUsuario(Usuario user){
   return repository.guardar(user);
 }

 public Usuario actuliaUsuario(Usuario user){
    return repository.actualizar(user);
 }
 public String eliminarUsuario(int id){
    repository.eliminar(id);
    return "el usuario fue eliminad@";
 }

}
