package com.example.backendcitas;

import com.example.backendcitas.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class BackendCitasApplication implements ApplicationRunner {


    private final IUsuarioService usuarioService;

    public static void main(String[] args) {
        SpringApplication.run(BackendCitasApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        usuarioService.cargarDatos();
    }
}
