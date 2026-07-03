package com.example.usuariosAustral.dto;

import jakarta.validation.constraints.*;

public record ActualizarUsuario (
@NotBlank
String nombre,

@NotBlank @Email String correo,

@NotNull Integer telefono,

@NotBlank String rol

){}

