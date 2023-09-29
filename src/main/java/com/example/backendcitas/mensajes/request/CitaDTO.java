package com.example.backendcitas.mensajes.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ide;

    @NotNull
    private String fecha;

    @NotBlank
    private String especialidad;

    @NotBlank
    private String observacion;

    @NotBlank
    private String numeroCita;

    private String usuario;
}
