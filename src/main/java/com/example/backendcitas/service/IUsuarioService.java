package com.example.backendcitas.service;

import com.example.backendcitas.mensajes.request.CitaDTO;
import com.example.backendcitas.mensajes.response.DefaultReponseDTO;

public interface IUsuarioService {

    DefaultReponseDTO listarUsuarios();

    DefaultReponseDTO eliminarUsuario(Integer id);

    DefaultReponseDTO buscarUsuario(String valor, String tipo);

    DefaultReponseDTO crearCita(Integer idUsuario, CitaDTO request);

    DefaultReponseDTO listarCitas();

    void cargarDatos();

}
