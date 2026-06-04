package com.example.usuariosAustral.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor


public class RequestUserDTO {
private Integer id;
private String nombre;
private String correo;
private int telefono;
private String rol;
}
