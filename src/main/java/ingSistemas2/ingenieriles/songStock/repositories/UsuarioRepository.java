package ingSistemas2.ingenieriles.songStock.repositories;

import ingSistemas2.ingenieriles.songStock.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByUsuarioAndCorreo(String usuario, String email);

    Usuario findByIdUsuario(Integer idUsuario);

    Usuario findByContrasenaAndCorreo(String contrasena, String email);

    @Modifying
    @Query(value = "UPDATE usuario SET estado = :estado WHERE idUsuario = :idUsuario", nativeQuery = true)
    int cambiarEstadoUsuario(@Param("idUsuario") Integer idUsuario, @Param("estado") Integer estado );
}
