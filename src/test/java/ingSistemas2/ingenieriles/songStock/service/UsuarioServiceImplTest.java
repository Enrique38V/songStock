package ingSistemas2.ingenieriles.songStock.service;

import ingSistemas2.ingenieriles.songStock.config.songExceptions.UsuarioFoundException;
import ingSistemas2.ingenieriles.songStock.dto.SesionDTO;
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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

    @Test
    void cambiarEstado() {
        Integer idUsuario = 1;
        Integer nuevoEstado = 2;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        usuarioService.cambiarEstado(idUsuario, nuevoEstado);
        String mensajeEsperado = "Se ha realizado el cambio del estado";
        assertTrue(outputStream.toString().trim().contains(mensajeEsperado));
        System.setOut(System.out);
    }

    @Test
    void inicioSesion() {
        SesionDTO sesionDTO = new SesionDTO();
        sesionDTO.setCorreo("correo");
        sesionDTO.setContrasena("contrasena");
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        when(usuarioRepository.findByContrasenaAndCorreo("contrasena", "correo")).thenReturn(usuario);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(1);
        when(usuarioHelper.helperUsuarioToDTO(usuario)).thenReturn(usuarioDTO);
        UsuarioDTO resultDTO = usuarioService.inicioSesion(sesionDTO);
        assertNotNull(resultDTO);
        assertEquals(1, resultDTO.getIdUsuario());
    }

    @Test
    void actualizarUsuario() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(1);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        when(usuarioHelper.helperUsuarioDTOToEntity(usuarioDTO)).thenReturn(usuario);
        usuarioService.actualizarUsuario(usuarioDTO);
        verify(usuarioRepository).save(usuario);
    }

    @Test
    void consultaUsuario() {
        Integer idUsuario = 1;
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(idUsuario);
        when(usuarioRepository.findByIdUsuario(idUsuario)).thenReturn(usuario);
        when(usuarioHelper.helperUsuarioToDTO(usuario)).thenReturn(usuarioDTO);
        UsuarioDTO resultDTO = usuarioService.consultaUsuario(idUsuario);
        assertNotNull(resultDTO);
        assertEquals(idUsuario, resultDTO.getIdUsuario());
    }
}