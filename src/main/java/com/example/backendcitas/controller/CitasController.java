package com.example.backendcitas.controller;

import com.example.backendcitas.mensajes.response.DefaultReponseDTO;
import com.example.backendcitas.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CitasController {

    private final IUsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> listarCitas(
    ) {
        DefaultReponseDTO response = usuarioService.listarCitas();
        return ResponseEntity.ok(response);
    }
}
