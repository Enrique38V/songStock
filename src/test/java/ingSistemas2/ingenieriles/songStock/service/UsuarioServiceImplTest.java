package ingSistemas2.ingenieriles.songStock.service;

import ingSistemas2.ingenieriles.songStock.config.songExceptions.UsuarioFoundException;
import ingSistemas2.ingenieriles.songStock.dto.UsuarioDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Usuario;
import ingSistemas2.ingenieriles.songStock.helpers.UsuarioHelper;
import ingSistemas2.ingenieriles.songStock.repositories.UsuarioRepository;
import ingSistemas2.ingenieriles.songStock.services.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioHelper usuarioHelper;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registroUsuario_UsuarioNoExiste() throws UsuarioFoundException {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUsuario("usuarioNuevo");
        usuarioDTO.setCorreo("correoNuevo");
        usuarioDTO.setContrasena("contrasena");
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        when(usuarioRepository.findByUsuarioAndCorreo("usuarioNuevo", "correoNuevo")).thenReturn(Arrays.asList());
        when(usuarioHelper.helperUsuarioDTOToEntity(usuarioDTO)).thenReturn(usuario);
        when(usuarioRepository.save(usuario)).thenReturn(usuario);
        Integer idUsuario = usuarioService.registroUsuario(usuarioDTO);
        assertNotNull(idUsuario);
        assertEquals(1, idUsuario);
    }

    @Test
    void registroUsuario_UsuarioYaExiste() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUsuario("usuarioExistente");
        usuarioDTO.setCorreo("correoExistente");
        usuarioDTO.setContrasena("contrasena");
        when(usuarioRepository.findByUsuarioAndCorreo("usuarioExistente", "correoExistente")).thenReturn(Arrays.asList(new Usuario()));
        assertThrows(UsuarioFoundException.class, () -> usuarioService.registroUsuario(usuarioDTO));
    }
}