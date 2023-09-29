package com.example.backendcitas.service;

import com.example.backendcitas.entidades.Cita;
import com.example.backendcitas.entidades.Usuario;
import com.example.backendcitas.mappers.MapperGeneral;
import com.example.backendcitas.mensajes.request.CitaDTO;
import com.example.backendcitas.mensajes.request.UsuarioDTO;
import com.example.backendcitas.mensajes.response.DefaultReponseDTO;
import com.example.backendcitas.repository.ICitaRepository;
import com.example.backendcitas.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;

    private final ICitaRepository citaRepository;

    private final RestTemplate restTemplate;

    @Override
    @Transactional(readOnly = true)
    public DefaultReponseDTO listarUsuarios() {

        List<UsuarioDTO> usuarios = usuarioRepository.findAll()
                .stream()
                .map(MapperGeneral::mapperTODTO)
                .toList();
        return new DefaultReponseDTO("200", "", usuarios);

    }

    @Override
    @Transactional
    public DefaultReponseDTO eliminarUsuario(Integer id) {

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado")
        );

        usuarioRepository.delete(usuario);
        return new DefaultReponseDTO("200", "Usuario eliminado", null);
    }

    @Override
    @Transactional(readOnly = true)
    public DefaultReponseDTO buscarUsuario(String valor, String tipo) {

        String valorLowerCase = valor.toLowerCase();

        Usuario usuario = usuarioRepository.findByEmail(valorLowerCase).orElse(null);
        UsuarioDTO usuarioDTO = usuario != null ? MapperGeneral.mapperTODTO(usuario) : null;

        return new DefaultReponseDTO("200", "", usuarioDTO);
    }

    @Override
    @Transactional
    public DefaultReponseDTO crearCita(Integer idUsuario, CitaDTO request) {


        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado")
        );


        Cita cita = MapperGeneral.mapperToEntity(request);
        cita.setUsuario(usuario);
        Cita citaGuardada = citaRepository.save(cita);
        System.out.println(citaGuardada.getIde());
        return new DefaultReponseDTO("201", "Cita creada", null);

    }

    @Override
    @Transactional(readOnly = true)
    public DefaultReponseDTO listarCitas() {

        List<CitaDTO> citas = citaRepository.findAll()
                .stream()
                .map(MapperGeneral::mappettoDTO)
                .toList();

        return new DefaultReponseDTO("200", "", citas);
    }

    @Override
    @Transactional
    public void cargarDatos() {

        final String END_POINT_USER = "https://dummyjson.com/users";
        long count = usuarioRepository.count();
        System.out.println("Cantidad de usuarios: " + count);

        if (count > 0) {
            System.out.println("Usuarios ya  se encuentran cargados");
            return;
        }

        Map<String, Object> usuarios = restTemplate.getForObject(END_POINT_USER, HashMap.class);

        if (Objects.isNull(usuarios)) {
            System.out.println("Usuarios no pudieron  ser cargados");
            return;
        }

        List<Object> usuariosList = (List<Object>) usuarios.get("users");

        List<Usuario> usuariosListEntity = new ArrayList<>();

        for (Object usuario : usuariosList) {
            Map<String, Object> usuarioMap = (Map<String, Object>) usuario;
            Usuario usuarioEntity = new Usuario();
            usuarioEntity.setFirstName((String) usuarioMap.get("firstName"));
            usuarioEntity.setLastName((String) usuarioMap.get("lastName"));
            usuarioEntity.setEmail((String) usuarioMap.get("email"));
            usuarioEntity.setAge((Integer) usuarioMap.get("age"));
            usuarioEntity.setImage((String) usuarioMap.get("image"));
            usuariosListEntity.add(usuarioEntity);
        }

        System.out.println(usuariosList);
        usuarioRepository.saveAll(usuariosListEntity);
    }
}
