package com.example.usuariosAustral.model;

import org.springframework.context.annotation.Import;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
private int id;
private String nombre;
private String correo;
private int telefono;
private int rol;
}
