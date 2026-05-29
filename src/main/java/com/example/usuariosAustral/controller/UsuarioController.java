package com.example.usuariosAustral.controller;

import com.example.usuariosAustral.model.Usuario;
import com.example.usuariosAustral.service.UsuarioService;

import  org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;





@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
 @Autowired
 private UsuarioService service;

 @GetMapping
 public List<Usuario>listarUsuarios(){
    return service.obtenerUsuario();
 }
 @GetMapping("/{id}")
 public Usuario buscaUsuario(@PathVariable int id){
    return service.buscarUsuario(id);
 }
 @PostMapping
 public Usuario guardarUsuario(@RequestBody Usuario user){
  return service.guardarUsuario(user);
  }
 
 @PutMapping
 public Usuario actualizarUsuario(@RequestBody Usuario user){
   return service.actuliaUsuario(user);
 }
 @DeleteMapping("/{id}")
 public void eliminarUsuario(@PathVariable int id){
   service.eliminarUsuario(id);
 }


 
}
