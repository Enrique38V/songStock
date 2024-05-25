package ingSistemas2.ingenieriles.songStock.repository;



import ingSistemas2.ingenieriles.songStock.entidades.Usuario;
import ingSistemas2.ingenieriles.songStock.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testFindByUsuarioAndCorreo() {
        // Given
        String usuario = "testUsuario";
        String correo = "test@example.com";
        Usuario usuario1 = new Usuario();
        usuario1.setUsuario(usuario);
        usuario1.setCorreo(correo);
        usuarioRepository.save(usuario1);
        List<Usuario> usuarios = usuarioRepository.findByUsuarioAndCorreo(usuario, correo);
        assertNotNull(usuarios);
        assertEquals(1, usuarios.size());
        assertEquals(usuario, usuarios.get(0).getUsuario());
        assertEquals(correo, usuarios.get(0).getCorreo());
    }

    @Test
    void testFindByIdUsuario() {
        Usuario usuario1 = new Usuario();
        usuario1.setIdUsuario(1);
        usuarioRepository.save(usuario1);
        Usuario usuario = usuarioRepository.findByIdUsuario(1);
        assertNotNull(usuario);
        assertEquals(1, usuario.getIdUsuario());
    }

    @Test
    void testFindByContrasenaAndCorreo() {
        String contrasena = "password";
        String correo = "test@example.com";
        Usuario usuario1 = new Usuario();
        usuario1.setContrasena(contrasena);
        usuario1.setCorreo(correo);
        usuarioRepository.save(usuario1);
        Usuario usuario = usuarioRepository.findByContrasenaAndCorreo(contrasena, correo);
        assertNotNull(usuario);
        assertEquals(contrasena, usuario.getContrasena());
        assertEquals(correo, usuario.getCorreo());
    }

    @Test
    void testCambiarEstadoUsuario() {
        Usuario usuario1 = new Usuario();
        usuario1.setIdUsuario(1);
        usuario1.setEstado(1);
        usuarioRepository.save(usuario1);
        int affectedRows = usuarioRepository.cambiarEstadoUsuario(1, 0);
        assertEquals(1, affectedRows);
        Usuario usuario = usuarioRepository.findByIdUsuario(1);
        assertNotNull(usuario);
        assertEquals(0, usuario.getEstado());
    }
}