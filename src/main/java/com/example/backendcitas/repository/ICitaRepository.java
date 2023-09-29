package com.example.backendcitas.repository;

import com.example.backendcitas.entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICitaRepository extends JpaRepository<Cita, Integer> {
}
