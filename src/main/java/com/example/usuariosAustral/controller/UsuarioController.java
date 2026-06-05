package com.example.usuariosAustral.controller;

import com.example.usuariosAustral.dto.CreateUsuarioRequest;
import com.example.usuariosAustral.dto.RequestUserDTO;
import com.example.usuariosAustral.model.Usuario;
import com.example.usuariosAustral.service.UsuarioService;

import jakarta.validation.Valid;

import  org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;








@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
  private final UsuarioService service;
        public UsuarioController(UsuarioService UsuarioService) {
            this.service = UsuarioService;        
}
@GetMapping
 public List<Usuario> getAllRecursos(){
  return this.service.getAllRecursos();
 }
@PostMapping
 public Usuario setRecursos(@RequestBody Usuario user){
    this.service.setById(user);
    return user;
 }
@PutMapping
public Usuario actualizarUsuario(@PathVariable int id, @Valid @RequestBody RequestUserDTO dto){
  return service.actualizarUsuario(id,dto );
}


@PostMapping
public Usuario guardarUsuario(@Valid @RequestBody CreateUsuarioRequest dto ){
  return service.guardarUsuario(dto);
}

@DeleteMapping("/{id}")
public String eliminarUsuario(@PathVariable int id){
  service.eliminarUsuario(id);
  return "El usuario ya no trabaja aca,ha sido borrad@";
}
}