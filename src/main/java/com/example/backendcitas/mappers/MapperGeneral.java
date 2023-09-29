package com.example.backendcitas.mappers;

import com.example.backendcitas.entidades.Cita;
import com.example.backendcitas.entidades.Usuario;
import com.example.backendcitas.enums.DateFormatEnum;
import com.example.backendcitas.mensajes.request.CitaDTO;
import com.example.backendcitas.mensajes.request.UsuarioDTO;
import com.example.backendcitas.util.DateFunction;

import java.security.PublicKey;

public class MapperGeneral {

    public static UsuarioDTO mapperTODTO(Usuario usuario) {


        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setIde(usuario.getIde() + "");
        usuarioDTO.setFirstName(usuario.getFirstName());
        usuarioDTO.setLastName(usuario.getLastName());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setAge(usuario.getAge() + "");
        usuarioDTO.setImage(usuario.getImage());

        return usuarioDTO;
    }


    public static Cita mapperToEntity(CitaDTO citaDTO) {
        Cita cita = new Cita();

        cita.setFecha(DateFunction.convertToDate(citaDTO.getFecha(), DateFormatEnum.DATE_TIME_FORMAT));
        cita.setEspecialidad(citaDTO.getEspecialidad());
        cita.setObservacion(citaDTO.getObservacion());
        cita.setNumeroCita(citaDTO.getNumeroCita());
        //cita.setUsuario(citaDTO.getUsuario());
        return cita;
    }

    public static CitaDTO mappettoDTO(Cita entity) {

        CitaDTO citaDTO = new CitaDTO();

        citaDTO.setFecha(DateFunction.convertToString(entity.getFecha(), DateFormatEnum.DATE_TIME_FORMAT));
        citaDTO.setEspecialidad(entity.getEspecialidad());
        citaDTO.setObservacion(entity.getObservacion());
        citaDTO.setNumeroCita(entity.getNumeroCita());
        return citaDTO;

    }
}

