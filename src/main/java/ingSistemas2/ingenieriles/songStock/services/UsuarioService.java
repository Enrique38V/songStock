package ingSistemas2.ingenieriles.songStock.services;

import ingSistemas2.ingenieriles.songStock.config.songExceptions.UsuarioFoundException;
import ingSistemas2.ingenieriles.songStock.dto.SesionDTO;
import ingSistemas2.ingenieriles.songStock.dto.UsuarioDTO;

public interface UsuarioService {

    Integer registroUsuario(UsuarioDTO usuarioDTO) throws UsuarioFoundException;

    void actualizarUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO consultaUsuario(Integer idUsuario);

    UsuarioDTO inicioSesion(SesionDTO sesion);

    void cambiarEstado(Integer idUsuario, Integer estado);

   // Integer validacionRegistro(UsuarioDTO usuarioDTO);
}
