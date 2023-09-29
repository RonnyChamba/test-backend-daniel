package com.example.backendcitas.controller;

import com.example.backendcitas.mensajes.request.CitaDTO;
import com.example.backendcitas.mensajes.response.DefaultReponseDTO;
import com.example.backendcitas.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(
            @PathVariable Integer id) {

        DefaultReponseDTO response = usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarUsuario(
            @RequestParam(defaultValue = "") String valor,
            @RequestParam(defaultValue = "") String tipo
    ) {

        DefaultReponseDTO response = usuarioService.buscarUsuario(valor, tipo);

        return ResponseEntity.ok(response);
    }


    @PostMapping("/{idUsuario}/cita")
    public ResponseEntity<?> crearCita(
            @PathVariable Integer idUsuario,
            @RequestBody CitaDTO request
    ) {
        DefaultReponseDTO response = usuarioService.crearCita(idUsuario, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
