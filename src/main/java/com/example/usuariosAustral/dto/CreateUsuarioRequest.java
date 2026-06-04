package com.example.usuariosAustral.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

public record CreateUsuarioRequest(
    @NotBlank(message = "El Nombre no puede estar en blanco") String nombre,
    @NotBlank(message = "EL correo no puede estar en blanco") @Email(message = "Correo inválido") String correo,
    @Positive(message = "El teléfono no puede tener numeros negativos") int telefono,
    @NotBlank(message = "El rol es obligatorio") String rol )
 
    {}