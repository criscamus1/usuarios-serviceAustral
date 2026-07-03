package com.example.usuariosAustral.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.usuariosAustral.dto.CreateUsuarioRequest;
import com.example.usuariosAustral.model.Usuario;
import com.example.usuariosAustral.service.UsuarioService;
import com.example.usuariosAustral.dto.ActualizarUsuario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuarios")
@Tag(
    name = "Usuarios",
    description = "Administración de usuarios del sistema Austral"
)
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping
    @Operation(
        summary = "Listar usuarios",
        description = "Obtiene todos los usuarios registrados."
    )
    @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllRecursos());
    }
    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar usuario",
        description = "Busca un usuario mediante su ID."
    )
    @ApiResponse(responseCode = "200", description = "Usuario encontrado")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.buscarUsuario(id));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
        summary = "Registrar usuario",
        description = "Registra un nuevo trabajador en la base de datos."
    )
    @ApiResponse(
        responseCode = "201",
        description = "Usuario creado correctamente",
        content = @Content(
            schema = @Schema(implementation = Usuario.class)
        )
    )
    @ApiResponse(
        responseCode = "400",
        description = "Datos inválidos"
    )
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        description = "Datos del nuevo usuario",
        required = true,
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = CreateUsuarioRequest.class),
            examples = @ExampleObject(
                value = """
                {
                  "nombre":"Jorge Sepulveda",  // use ia aca para probar
                  "correo":"jorge@austral.cl",
                  "telefono":912345678,
                  "rol":"TECNICO"
                }
                """
            )
        )
    )
    public ResponseEntity<Usuario> guardarUsuario(

            @Valid
            @RequestBody
            CreateUsuarioRequest dto) {

        Usuario usuario = usuarioService.guardarUsuario(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    @PutMapping("/{id}")
    @Operation(
        summary = "Actualizar usuario",
        description = "Actualiza la información de un usuario."
    )
    @ApiResponse(responseCode = "200", description = "Usuario actualizado")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
public ResponseEntity<Usuario> actualizarUsuario(
        @PathVariable Integer id,
        @Valid
        @RequestBody
        ActualizarUsuario dto) {
    Usuario usuario = usuarioService.actualizarUsuario(id, dto);
    return ResponseEntity.ok(usuario);
}
    @DeleteMapping("/{id}")
    @Operation(
        summary = "Eliminar usuario",
        description = "Elimina un usuario del sistema."
    )
    @ApiResponse(responseCode = "204", description = "Usuario eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {

        usuarioService.eliminarUsuario(id);

        return ResponseEntity.noContent().build();

    }

}