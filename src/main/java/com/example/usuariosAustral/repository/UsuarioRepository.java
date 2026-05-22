package com.example.usuariosAustral.repository;

import org.springframework.stereotype.Repository;

import com.example.usuariosAustral.model.Usuario;

import java.util.ArrayList;
import java.util.List;



@Repository
public class UsuarioRepository {

 private List<Usuario> listaUsuarios =new ArrayList<>();

 public List<Usuario> obtenerUsuario(){
    return listaUsuarios;
 }

 public Usuario buscarUsuarioPorId(int id){
    for(Usuario usuario:listaUsuarios){
        if (usuario.getId()== id){
            return usuario;
        }
    }
    return null;
 }

 
 public Usuario actualizar(Usuario user){
    int id = 0;
    int idPosicion=0;

    for (int i = 0 ; i <listaUsuarios.size();i++){
        if(listaUsuarios.get(i).getId()==user.getId()){
            id =user.getId();
            idPosicion=1;
        } 
    }
    Usuario user1 =new Usuario();
    user1.setId(id);
    user1.setNombre(user.getNombre());
    user1.setCorreo(user.getCorreo());
    user1.setTelefono(user.getTelefono());
    user1.setRol(user.getRol());
    listaUsuarios.set(idPosicion,user1);
    return user1;
 }
 public Usuario guardar(Usuario user){
    listaUsuarios.add(user);
    return user;
 }

 public void eliminar (int id){
    Usuario usuario =buscarUsuarioPorId(id);
    if(usuario != null){
        listaUsuarios.remove(usuario);
    }
 }



}
