package ingSistemas2.ingenieriles.songStock.delegate;

import ingSistemas2.ingenieriles.songStock.config.songExceptions.UsuarioFoundException;
import ingSistemas2.ingenieriles.songStock.delegate.impl.UsuarioDelegateImpl;
import ingSistemas2.ingenieriles.songStock.dto.SesionDTO;
import ingSistemas2.ingenieriles.songStock.dto.UsuarioDTO;
import ingSistemas2.ingenieriles.songStock.services.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class UsuarioDelegateImplTest{

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioDelegateImpl usuarioDelegate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registroUsuario() throws UsuarioFoundException {
        // Arrange
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setContrasena("password");
        // Act
        usuarioDelegate.registroUsuario(usuarioDTO);
        // Assert
        verify(usuarioService).registroUsuario(any(UsuarioDTO.class));
    }

    @Test
    void inicioSesion() {
        // Arrange
        SesionDTO sesionDTO = new SesionDTO();
        sesionDTO.setContrasena("password");
        // Act
        usuarioDelegate.inicioSesion(sesionDTO);
        // Assert
        verify(usuarioService).inicioSesion(any(SesionDTO.class));
    }
}