package com.example.usuariosAustral.service;

import com.example.usuariosAustral.model.Usuario;
import com.example.usuariosAustral.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class UsuarioService {
 @Autowired
 private UsuarioRepository repository;


 @GetMapping
 public List<Usuario>obtenerUsuario(){
    return repository.obtenerUsuario();
 }
 @GetMapping
 public Usuario buscarUsuario(int id){
    return repository.buscarUsuarioPorId(id);
 }
 @PostMapping
 public Usuario guardarUsuario(Usuario user){
   return repository.guardar(user);
 }

 @PostMapping
 public Usuario actuliaUsuario(Usuario user){
    return repository.actualizar(user);
 }
 @DeleteMapping
 public void eliminarUsuario(int id){
    repository.eliminar(id);
 }

}
