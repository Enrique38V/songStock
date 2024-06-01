package ingSistemas2.ingenieriles.songStock.delegate;

import ingSistemas2.ingenieriles.songStock.config.songExceptions.UsuarioCreationException;
import ingSistemas2.ingenieriles.songStock.dto.SesionDTO;
import ingSistemas2.ingenieriles.songStock.dto.UsuarioDTO;

public interface UsuarioDelegate {

    void registroUsuario(UsuarioDTO registro) throws UsuarioCreationException;

    UsuarioDTO inicioSesion(SesionDTO sesion);

    String consultarGenero();

}
