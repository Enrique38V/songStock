package ingSistemas2.ingenieriles.songStock.repository;
import ingSistemas2.ingenieriles.songStock.entidades.Usuario;
import ingSistemas2.ingenieriles.songStock.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void testFindByUsuarioAndCorreo() {
        String usuario = "edi";
        String correo = "max@poligran.edu.co";
        Usuario usuario1 = new Usuario();
        usuario1.setUsuario(usuario);
        usuario1.setCorreo(correo);
        usuarioRepository.save(usuario1);
        List<Usuario> foundUsers = usuarioRepository.findByUsuarioAndCorreo(usuario, correo);
        assertNotNull(foundUsers);
        assertEquals(1, foundUsers.size());
        assertEquals(usuario, foundUsers.get(0).getUsuario());
        assertEquals(correo, foundUsers.get(0).getCorreo());
    }

    @Test
    public void testFindByIdUsuario() {
        Usuario usuario1 = new Usuario();
        usuario1.setIdUsuario(1);
        usuarioRepository.save(usuario1);
        Usuario foundUser = usuarioRepository.findByIdUsuario(1);
        assertNotNull(foundUser);
        assertEquals(1, foundUser.getIdUsuario());
    }

    @Test
    public void testFindByContrasenaAndCorreo() {
        String contrasena = "password123";
        String correo = "example@example.com";
        Usuario usuario1 = new Usuario();
        usuario1.setContrasena(contrasena);
        usuario1.setCorreo(correo);
        usuarioRepository.save(usuario1);
        Usuario foundUser = usuarioRepository.findByContrasenaAndCorreo(contrasena, correo);
        assertNotNull(foundUser);
        assertEquals(contrasena, foundUser.getContrasena());
        assertEquals(correo, foundUser.getCorreo());
    }
}