package com.example.backendcitas.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "citas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cita implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ide;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    private String especialidad;

    private String observacion;

    private String numeroCita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ide_usuario")
    private Usuario usuario;
}
